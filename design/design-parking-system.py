class ParkingSystem:

    def __init__(self, big: int, medium: int, small: int):
        self.arr = [big, medium, small]

        

    def addCar(self, carType: int) -> bool:

        self.carType = carType
        if(carType == 1 and self.arr[0] >= 1):
            self.arr[0] -= 1
            return True
        
        if(carType == 1 and self.arr[0] < 1):
            return False
        
        if(carType == 2 and self.arr[1] >= 1):
            self.arr[1] -= 1
            return True
        
        if(carType == 2 and self.arr[1] < 1):
            return False
        
        if(carType == 3 and self.arr[2] >= 1):
            self.arr[2] -= 1
            return True
        
        if(carType == 3 and self.arr[2] < 1):
            return False

        
        


# Your ParkingSystem object will be instantiated and called as such:
# obj = ParkingSystem(big, medium, small)
# param_1 = obj.addCar(carType)