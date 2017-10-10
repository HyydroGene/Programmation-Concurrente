from tkinter import *
from threading import Thread, RLock
from random import *
from math import *
import time

import Ex3
import Main
import Collision

color=['red','blue','green','black','yellow','white','orange','violet','brown']
taille=50	

class ball(object):
	liste=list()
	def __init__(self,name,x,y,col=choice(color)):
		ball.liste.append(self)
		self.name = name
		self.x = x
		self.y = y
		self.col=col
		self.dirX=randint(0,1)
		self.dirY=randint(0,1)
		if self.dirX==0:
			self.dirX=-1
		if self.dirY==0:
			self.dirY=-1

	def update(self,p):
		x=p.x-self.x
		y=p.y-self.y
		dist=x*x+y*y
		if (sqrt(dist))<=(taille):
			Main.fenetre.nombreBalle-=2
			Main.fenetre.nb_ball["text"]=("Balle(s) a l'écran : {}".format(Main.fenetre.nombreBalle))

			# On incrémente le score de 1 pour chaque balle (donc de 2 car pour une collision, ils doivent forcément être 2)

			Main.fenetre.score+=2
			Main.fenetre.n_score["text"]=("Score: {}".format(Main.fenetre.score))
			Main.fenetre.canvas.delete(self.name)
			ball.liste.remove(self)
			Main.fenetre.canvas.delete(p.name)
			ball.liste.remove(p)
