class ParkingSystem:

    def __init__(self, big: int, medium: int, small: int):
        self.arr = [0, big, medium, small]

        

    def addCar(self, carType: int) -> bool:

        if(self.arr[carType] >= 1):
            self.arr[carType] -= 1
            return True
        
        if(self.arr[carType] < 1):
            return False
        
        if(self.arr[carType] >= 1):
            self.arr[carType] -= 1
            return True
        
        if(self.arr[carType] < 1):
            return False
        
        if(self.arr[carType] >= 1):
            self.arr[carType] -= 1
            return True
        
        if(self.arr[carType] < 1):
            return False

        
        


# Your ParkingSystem object will be instantiated and called as such:
# obj = ParkingSystem(big, medium, small)
# param_1 = obj.addCar(carType)