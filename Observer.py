# Observer & Subject class and concrete class
class Subject:
    def register_observer(self,observer):
        raise NotImplementedError
    def remove_observer(self,observer):
        raise NotImplementedError
    def notify_observer(self):
        raise NotImplementedError

class Observer:
    def update(self,status):
        raise NotImplementedError

# Subject concrete class: Zookeeper
# give the observer the value of status
class Zookeeper(Subject):
    def __init__(self, animallist):
        self.animallist = animallist
        self.status     = None
        self.observers  =[]

    def register_observer(self,observer):
        self.observers.append(observer)
    def remove_observer(self,observer):
        self.observers.remove(observer)
    def notify_observer(self,status):
        for observer in self.observers:
            observer.update(status)

    def change_status(self,status):
        self.notify_observer(status)

    def set_status(self,status):
        self.status =status
        self.change_status(self.status)

    def wakeup(self):
        self.set_status("wake up")
        print("ZooKeeper wake up the animals:")
        for animal in self.animallist:
            print(animal.r2wakeup())

    def rollcall(self):
        self.set_status("roll call")
        print("ZooKeeper rollcall the animals:")
        for animal in self.animallist:
            print(animal.r2call())

    def feed(self):
        self.set_status("feed")
        print("ZooKeeper feed the animals:")
        for animal in self.animallist:
            print(animal.r2feed())

    def exercise(self):
        self.set_status("exercise")
        print("ZooKeeper exercise the animals:")
        for animal in self.animallist:
            print(animal.r2exercise())

    def shutdown(self):
        self.set_status("shutdown")
        print("ZooKeeper  the shutdown animals:")
        for animal in self.animallist:
            print(animal.r2shutdown())


# Observer concrete class: ZooAnnouncer
class ZooAnnouncer(Observer):
    def __init__(self,zookeeper):
        self.zookeeper = zookeeper
        self.zookeeper.register_observer(self)
        self.status = None
    def update(self,status):
        self.status =status
        self.display(status)
    def display(self,status):
        print("Hi, this is the Zoo Announcer.  The Zookeeper is about to ",self.status,"the animals")


