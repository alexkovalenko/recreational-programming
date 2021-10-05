import turtle
import random
import time

n = 50 
s = turtle.getscreen()
turtle.setup(1000,1000)
turtle.title("Game of life")
turtle.speed(0)
turtle.hideturtle()
turtle.tracer(0, 0)

lifeturtle = turtle.Turtle()
lifeturtle.up()
lifeturtle.speed(0)
lifeturtle.hideturtle()
lifeturtle.color('black')

def drawLine(x1,y1,x2,y2):
  turtle.up()
  turtle.goto(x1,y1)
  turtle.down()
  turtle.goto(x2,y2)

def drawGrid():
  turtle.pencolor("gray")
  i = -400
  for x in range(n + 1):
      drawLine(i, -400, i, 400)
      drawLine(-400, i, 400, i)
      i += 800/n

life = []
def generateLife():
  for i in range(n):
    liferow = []
    for j in range(n):
      liferow.append(1 if random.randint(0, 7) == 0 else 0)
    life.append(liferow)
  return life

def mockLife():
  return [
    [0,0,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0,0],
    [0,0,0,0,1,1,0,0,0,0],
    [0,0,0,1,0,0,1,0,0,0],
    [0,0,0,0,1,1,0,0,0,0],
    [0,0,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0,0]
  ]

def drawSquare(x, y, size):
  lifeturtle.up()
  lifeturtle.goto(x, y)
  lifeturtle.down()
  lifeturtle.seth(0)
  lifeturtle.begin_fill()
  for i in range(4):
    lifeturtle.fd(size)
    lifeturtle.lt(90)
  lifeturtle.end_fill()

def drawCell(x, y):
  lx = 800/n*x - 400
  ly = 800/n*y - 400
  drawSquare(lx + 1, ly + 1, 800/n)

def drawLife(life):
  lifeturtle.clear()
  for i in range(n):
    for j in range(n):
      if life[i][j] == 1: drawCell(i,j)

def isSurviveCriteriaPresent(life,x,y):
  sum = 0
  if x < n - 1 and y < n - 1:
    sum += life[x+1][y+1]
  if x < n - 1:
    sum += life[x+1][y]
  if y < n - 1:
    sum += life[x][y+1]
  if x > 0:
    sum += life[x-1][y]
  if y > 0:
    sum += life[x][y-1]
  if x > 0 and y > 0:
    sum += life[x-1][y-1]
  if y > 0 and x < n - 1:
    sum += life[x+1][y-1]
  if x > 0 and y < n - 1:
    sum += life[x-1][y+1]
  if life[x][y] == 1 and sum < 2:
    return False
  if life[x][y] == 1 and (sum == 2 or sum == 3):
    return True
  if life[x][y] == 1 and sum > 3:
    return False
  if life[x][y] == 0 and sum == 3:
    return True
  return False

def recalculateLife(life):
  newLife = []
  for i in range(n):
    newLifeRow = []
    for j in range(n):
      newLifeRow.append(1 if isSurviveCriteriaPresent(life, i,j) else 0)
    newLife.append(newLifeRow)
  return newLife

drawGrid()
life = generateLife()
generation = 0
start = time.time()
while True:
  drawLife(life)
  s.update()
  life = recalculateLife(life)
  generation += 1
  print(f"speed: {(time.time() - start) / generation}", end = "\r")

turtle.done()
