from tkinter import *
from threading import Thread, RLock

from random import *
from math import *

import time

import Balle
import Collision
import Ex3



#Variable global pour le rayon des cercles
taille=50

#Variable pour les différentes couleur des cercles
color=['red','blue','green','black','yellow','white','orange','violet','brown']


class main(Thread):

	def __init__(self):

		Thread.__init__(self)
		self.fenetre=Tk()

		self.nombreBalle = 0
		self.score = 0

		self.daemon = True
		self.canDo = True

		self.temps = int(time.clock()) # Gestion du timer

		#texte nombre de ball
		self.nb_ball=Label(self.fenetre,text="Balle(s) a l'écran : {}".format(self.nombreBalle))
		self.nb_ball.pack()

		# On met en place le système de score : 
		self.n_score = Label(self.fenetre,text="Score: {}".format(self.score))
		self.n_score.pack() 

		# On met en place le timer : 
		self.temps = Label(self.fenetre,text="Timer : {}".format(self.temps))
		self.temps.pack()

		# Ici on définis la taille de la fenetre :
		self.canvas = Canvas(self.fenetre, width=800, height=400, background='white')
		self.canvas.pack()
	
		self.Frame_balle=Frame(self.fenetre, borderwidth=2, relief=RIDGE)
		self.Frame_balle.pack()

		# bouton ajout :
		self.ajouter = Button(self.Frame_balle,text="Ajouter",command=self.ajouter)
		self.ajouter.pack(side=TOP)
		# bouton retirer
		self.retirer = Button(self.Frame_balle,text="Retirer",command=self.retirer)
		self.retirer.pack(side=BOTTOM)

		#Bouton start/pause : 
		self.pause = Button(self.fenetre,text="start / pause",command=self.pause)
		self.pause.pack(side=LEFT)

	def run(self):
		# On ne fais rien
		pass
	
	def pause(self):

		# On test si on est en pause grâce à un booleen, pour effectuer l'action qu'une fois
		if collision.canDo:
			collision.canDo=False
		else:
			collision.canDo=True

	def ajouter(self):

		x=randint(taille,800-taille)
		y=randint(taille,400-taille)
		col=choice(color)

		name=self.canvas.create_oval(x,y,x+taille,y+taille,fill=col)
		Balle.ball(name,x,y,col)

		self.nombreBalle+=1
		self.nb_ball["text"]=("nombre de balle: {}".format(self.nombreBalle))


	def retirer(self):
		if ball.liste!=[]:
			supp=self.canvas.find_all()
			self.canvas.delete(supp[len(supp)-1])
			Balle.ball.liste.pop(len(Balle.ball.liste)-1)
			self.nombreBalle-=1
			self.nb_ball["text"]=("nombre de balle: {}".format(self.nombreBalle))


fenetre=main()
collision=Collision.calcul()

fenetre.start()


collision.start()


fenetre.fenetre.mainloop()


fenetre.canDo=False