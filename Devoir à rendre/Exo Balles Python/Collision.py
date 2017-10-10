from tkinter import *
from threading import Thread, RLock
from random import *
from math import *
import time

import Ex3
import Main
import Balle

color=['red','blue','green','black','yellow','white','orange','violet','brown']
taille=50

class calcul(Thread):
	def __init__(self):
		Thread.__init__(self)

		self.daemon=True
		self.canDo=True

	def run(self):

		while True:
			Main.fenetre.temps["text"]=("Timer : {}".format(int(time.clock() ) ) )

			if self.canDo:

				for i in Balle.ball.liste:

					Main.fenetre.canvas.coords(i.name, i.x+i.dirX, i.y+i.dirY, i.x+i.dirX+taille, i.y+i.dirY+taille)

					i.x+=i.dirX
					i.y+=i.dirY

					# On test les collisions par rapport à chaque extrémité (en x et y ) : 

					if i.x==0 or i.x==800-taille:
						i.dirX=-i.dirX

					if i.y==0 or i.y==400-taille:
						i.dirY=-i.dirY

					for balles in Balle.ball.liste:
						if balles!=i:
							balles.update(i)
			time.sleep(0.04) # Techniquement, cela représente la vitesse des balles.