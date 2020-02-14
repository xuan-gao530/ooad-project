import random
import abc
from Observer import Zookeeper,ZooAnnouncer
from strategy import FeedMeat
from strategy import FeedGrass
from strategy import FeedWater

feed_meat = FeedMeat()
feed_grass= FeedGrass()
feed_water= FeedWater()

class Animal(object):
    # setting feestrategy
    def __init__(self, name, type, feedstrategy):
        self.name = name
        self.type = type
        self._feedstrategy = feedstrategy

    def r2wakeup(self):
        return self.name, self.type, "wakeup"

    def r2call(self):
        return self.name, self.type, "make noise"

    def r2exercise(self):
        return self.name, self.type, "run"

    def r2shutdown(self):
        return self.name, self.type, "sleep"

    def r2feed(self):
        return self.name, self.type, self._feedstrategy.r2feed()

    def setFeedBehavior(self, fb):
        self._feedstrategy = fb;


# subclass
class Pachyderm(Animal):
    # setting the feestrategy for Pachyderm
    def __init__(self, name, type,feedstrategy):
        super(Pachyderm, self).__init__(name, type, feedstrategy)


class Feline(Animal):
    # setting the feedstrategy for all Feline animals as feed_meat
    def __init__(self, name, type):
        super(Feline, self).__init__(name, type, feed_meat)

    def r2call(self):
        return self.name, self.type, "roar"


class Canine(Animal):
    # setting the feestrategy for Canine
    def __init__(self, name, type,feedstrategy):
        super(Canine, self).__init__(name, type,feedstrategy)

    def r2call(self):
        return self.name, self.type, "bark"


# sub-subclass Pachyderm
class Hippo(Pachyderm):
    def __init__(self, name, type):
        super(Hippo, self).__init__(name, type, feed_meat)

    def r2exercise(self):
        return self.name, self.type, "walk"


class Rhino(Pachyderm):
    def __init__(self, name, type):
        super(Rhino, self).__init__(name, type, feed_water)

    def r2exercise(self):
        return self.name, self.type, "wander"


class Elephant(Pachyderm):
    def __init__(self, name, type):
        super(Elephant, self).__init__(name, type,feed_grass)

    def r2exercise(self):
        return self.name, self.type, "roam"


# sub-subclass Feline
class Tiger(Feline):
    def __init__(self, name, type):
        super(Tiger, self).__init__(name, type)


class Lion(Feline):
    def __init__(self, name, type):
        super(Lion, self).__init__(name, type)


class Cat(Feline):
    def __init__(self, name, type):
        super(Cat, self).__init__(name, type)

    def r2call(self):
        return self.name, self.type, "mewmew"


# sub-subclass Canine
class Wolf(Canine):
    def __init__(self, name, type):
        super(Wolf, self).__init__(name, type,feed_water)

    def r2shutdown(self):
        return self.name, self.type, "run"


class Dog(Canine):
    def __init__(self, name, type):
        super(Dog, self).__init__(name, type,feed_meat)

    def r2shutdown(self):
        r2shutd = ["sleep", "run", "hiss"]
        num = random.randint(0, 2)
        return self.name, self.type, r2shutd[num]




if __name__ == "__main__":
    animallist = []
    namelist = ["Henry", "Harry", "Eaton", "Edith", "Ross", "Rachel", "Tom", "Taylor", "Lora", "Leon", "Carl", "Chris",
                "West", "Wendy", "David", "Darcy", "Dolly", "Dove"]
    typelist = ["Hippo", "Elephant", "Rhino", "Tiger", "Lion", "Cat", "Wolf", "Dog"]

    for i in range(2):
        animallist.append(Hippo(namelist[i], typelist[0]))
    for i in range(2, 4):
        animallist.append(Elephant(namelist[i], typelist[1]))
    for i in range(4, 6):
        animallist.append(Rhino(namelist[i], typelist[2]))
    for i in range(6, 8):
        animallist.append(Tiger(namelist[i], typelist[3]))
    for i in range(8, 10):
        animallist.append(Lion(namelist[i], typelist[4]))
    for i in range(10, 12):
        animallist.append(Cat(namelist[i], typelist[5]))
    for i in range(12, 14):
        animallist.append(Wolf(namelist[i], typelist[6]))
    for i in range(14, 18):
        animallist.append(Dog(namelist[i], typelist[7]))

    z = Zookeeper(animallist)
    a = ZooAnnouncer(z)
    result = [z.wakeup(), z.rollcall(), z.exercise(), z.feed(), z.shutdown()]

    b = animallist[14]   # dog feedbehavior defualt is feed with meat
    print('\n'"Name:David, Type:Dog, print the default feedbehavior")
    print(b.r2feed())
    b.setFeedBehavior(feed_water)   # setbehavior ---> feed with hwater
    print("Using the setbehavior() to change the feedbehavior to feed with water")
    print(b.r2feed())





