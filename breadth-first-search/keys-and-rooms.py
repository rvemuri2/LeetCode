class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:

        isVisited = set()

        def dfs(room):
            isVisited.add(room)
            for i in rooms[room]:
                if i not in isVisited:
                    dfs(i)
        
        dfs(0)

        return len(isVisited) == len(rooms) 

        