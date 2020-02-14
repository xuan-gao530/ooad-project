# strategy for feed behavior
import abc

class FeedBehavior(object):
    __metaclass__ = abc.ABCMeta

    @abc.abstractmethod
    def r2feed(self):
        raise NotImplementedError


class FeedMeat(FeedBehavior):
    def r2feed(self):
        return "Feed with meat"


class FeedGrass(FeedBehavior):
    def r2feed(self):
        return 'Feed with grass'


class FeedWater(FeedBehavior):
    def r2feed(self):
        return "Feed with water"
