# The-Skyline-Problem-in-Java
Problem Statement:

A city's skyline is formed by several rectangular buildings in a 2D plane.

Each building is represented by:

buildings[i] = [left, right, height]

Where:

left = x-coordinate of left edge

right = x-coordinate of right edge

height = height of building


You must return the skyline as a list of “key points”:
Each key point is [x, height], where height changes.


---

Example:

Input:
buildings = [
  [2,9,10],
  [3,7,15],
  [5,12,12],
  [15,20,10],
  [19,24,8]
]

Output:
[
  [2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]
]


---

💡 Approach:

We use a Sweep Line Algorithm + Max Heap:

1. Convert all buildings into “events”:

Start of building: (x, -height)

End of building: (x, height) (negative height marks start)



2. Sort events:

If two events have same x: process start before end

Otherwise sort by x-coordinate



3. Use a max heap (PriorityQueue) to keep current building heights.


4. When height changes (max height differs from previous), record [x, currentMax].

