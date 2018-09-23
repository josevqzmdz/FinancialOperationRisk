'''
    Persona:
    - Id
    - Nombre
    - Apellido Paterno
    - Apellido Materno
    - RFC
    -Movimientos [folio,dict()]
        Folio
        Fecha
        Cantidad
        Conceptos
    Procesos:
    - Cantidad
    - Concepto
    - Ingresos o egresos
    - Fecha

    Salida:
    - Posibles decisiones
    - Estadistica

    TODO:
    - 23/9/18 añadido el modulo para enviar datos a la base de datos (127.0.0.1)
    Por el momento solo se envia el nombre, apellido paterno y materno, y la contraseña.

    La contraseña solo se toma del segundo form 
    https://stackoverflow.com/questions/10299148/mysql-error-1045-28000-access-denied-for-user-billlocalhost-using-passw
'''


import sys

import mysql.connector
from mysql.connector import errorcode

from datetime import date, datetime, timedelta
# pagina 17

from PyQt5 import uic, QtWidgets



# la clase "MySQLCursor" instancia objetos que pueden ejecutar operaciones como SQL statements
# pagina 63 de la guia connector-python

qtCreatorFile = "Ui_Principal.ui" # Nombre del archivo

Ui_MainWindow, QtBaseClass = uic.loadUiType(qtCreatorFile)

class MyApp(QtWidgets.QMainWindow, Ui_MainWindow):

    def __init__(self): #constructor
        QtWidgets.QMainWindow.__init__(self) #crea la parte visual
        Ui_MainWindow.__init__(self) #convierte el ui a codigo entendible en python
        self.setupUi(self) #carga el codigo convertido

        #VARIABLES
        self.ID=int()
        self.cont=int()

        #ESTRUCTURAS DE DATOS
        self.Persona={'ID':1,'nombre':"usuario1",'apellido_paterno':"usuario1", 'apellido_materno':"Lopez",'RFC':'1000' }
        # El {self.Persona['Id']... redirecciona al ID del objeto persona que se creo y sera su clave al diccionario
        # personas para encontrar el objeto persona ...:self.Persona...
        self.Personas={self.Persona['ID']:self.Persona}

        self.pb_OK.clicked.connect(self.conexion_mySQL)


    #EStos datos son de pruba para tener el Id[1] y Id[2]
        self.Persona = {'ID': 2, 'nombre': "usuario2", 'apellido_paterno': "apellido2", 'apellido_materno': "apellido2",
                        'RFC': '2000'}
        # El {self.Persona['Id']... redirecciona al ID del objeto persona que se creo y sera su clave al diccionario
        # personas para encontrar el objeto persona ...:self.Persona...
        self.Personas={self.Persona['ID']:self.Persona}

        #LISTENERS
        #Este crea un listener para conectar a un slot cuando dispare la accion click
        # del push button OK que esta diseñado en pyQt designer
        #Ojo debe llamarse igual que el object name de PYqt, en el caso del slot no hay pro
        self.pb_OK.clicked.connect(self.ok)

        self.sb_ID.setMinimum(1)
        self.sb_ID.setMaximum(50)

        self.sb_ID.setSingleStep(1)
        self.sb_ID.setValue(0)
        self.sb_ID.valueChanged.connect(self.llenar_campos)

#----------------------------------------------------------------------------------------------------------------------#
#Listeners

    #Spinner Box "Id"
    def llenar_campos(self):
        #Aqui busco el valor del ID del
        try:

            self.ID = int(self.sb_id.value())
            print("Id buscado: " + str(self.ID))
            print(self.Personas.get(self.ID))
            #Mostrando en line edit

        except:
            e = sys.exc_info()[0]
            print("<p>Error: %s</p>" % e)

    #Push button "Ok"
    def ok(self):
        #El diccionario Personas guarda a una persona.
        # Acceder a sus atributos mediante su ID.

        #Aqui solo los estoy imprimiendo para verificar si existen

        self.Personas[self.ID]=self.ID
        print("OK")

        self.Persona["ID"] = self.ID
        self.Persona["apellido_paterno"] = self.le_apellido_paterno.text()
        self.Persona["apellido_materno"] = self.le_apellido_materno.text()
        self.Persona["nombre"] = self.le_nombre.text()

        self.Personas[self.ID]=self.Persona

       #En mantenimiento
        '''self.Persona.append(self.le_nombre.text())
        self.Persona.append(self.le_apellido_paterno.text())
        self.Persona.append(self.le_apellido_materno.text())
        self.Persona.append(self.le_concepto.text())
        print("OK")'''

#----------------------------------------------------------------------------------------------------------------------#

    def mostrar_Personas(self,):
        self.le_nombre.setText(str(self.Personas.get(self.ID).get('nombre', 'null')))
        self.le_apellido_materno.setText(str(self.Personas.get(self.ID).get('apellido_materno', 'null')))
        self.le_apellido_paterno.setText(str(self.Personas.get(self.ID).get('apellido_paterno', 'null')))

    # ----------------------------------------------------------------------------------------------------------------------#

    def mensaje(self, msj):
        m = QtWidgets.QMessageBox()
        m.setText(msj)
        m.exec_()

    #conexion a mySQL
    def conexion_mySQL(self):
        # este comando conecta la base de datos de Usuario y envia los parametros
        # establecidos en el form

        try:

            nombre = str(self.le_nombre.text())
            apaterno = str(self.le_apellido_paterno.text())
            amaterno = str(self.le_apellido_materno.text())

            cantidad = str(self.le_cantidad.text())
            contraseña = str(self.le_contrasena_2.text())

            conexion = mysql.connector.connect(user=nombre,
                                               password=contraseña,
                                               database="127.0.0.1")

            cursor = conexion.cursor()

            mañana = datetime.now().date() + timedelta(days=1)

            # asi se inserta los valores como cadena, directamente a la base de datos phpmyadmin
            # este string añade la informacion introducida en el form para la informacion de persona



            añadir_persona = ("CREATE USER ",
                              nombre,"@localhost "
                             "IDENTIFIED BY '", contraseña,"'")

            otorgar_privilegios = ("grant all privileges on *.* to ", nombre,"@localhost "
                                   " with grant option")

            cursor.execute(añadir_persona)

            cursor.execute(otorgar_privilegios)

            añadir_persona_info = ("INSERT INTO usuario"
                                   "(nombre, apellido_paterno, apellido_materno, contraseña)"
                                   "VALUES (%s, %s, %s, %s)"
                                   )

            datos_persona = (nombre, apaterno, amaterno, contraseña)

            cursor.execute(añadir_persona_info, datos_persona)

            conexion.commit()

            conexion.close(self)

            self.mensaje("creacion de usuario exitosa")

        except mysql.connector.Error as err:
            if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
                print("nombre o usuario equivocado o inexistente")
                print(err)
            elif err.errno == errorcode.ER_BAD_DB_ERROR:
                print("base de datos no existe")
            else:
                print(err)


if __name__ == "__main__":
    app =  QtWidgets.QApplication(sys.argv)
    window = MyApp()
    window.show()
    sys.exit(app.exec_())