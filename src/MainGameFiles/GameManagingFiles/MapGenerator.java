package MainGameFiles.GameManagingFiles;

import java.util.ArrayDeque;
import java.util.ArrayList; // necessary
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JTable;

public final class MapGenerator {
	private final class Coords {
		public final int x; // x
		public final int y; // y
		public final boolean isTop; // isTop
		public final boolean isRight; // isRight
		public final boolean isBottom; // isBottom
		public final boolean isLeft; // isLeft

		public Coords(int x, int y) {
			this.x = x;
			this.y = y;
			this.isTop = (y <= 0);
			this.isBottom = (y >= height - 1);
			this.isLeft = (x <= 0);
			this.isRight = (x >= width - 1);
		}

		public boolean equals(Object object) {
			if (!(object instanceof Coords))
				return false;

			if (object == this)
				return true;

			Coords coords = (Coords) object;
			if (coords.x == this.x && coords.y == this.y)
				return true;
			return false;
		}
	}

	private int[][] map; // the integer map (basically the room number once set)
	private Object[][] generatingMap; // object[][] because ArrayList<T>[][] doesn't work :(
	private boolean[][] isSet; // boolean[][] used to check if the entire map is set
	private boolean isCollapsed = false; // set in Iterate() and checked to stop iterating
	private Deque<Coords> stack = new ArrayDeque<Coords>(); // fancy stack to allow Propagate() to work
	protected int height; // set in Initalizer, used in MapGenerator$Coords
	protected int width; // ditto
	// middlePossible ArrayList allows for quick setting up of generatingMap
	private final ArrayList<Integer> middlePossible = new ArrayList<Integer>(
			Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
	// cannotConnectX arrays are useful for edge pruning and for when something
	// cannot connect
	private final ArrayList<Integer> cannotConnectNorth = new ArrayList<Integer>(
			Arrays.asList(0, 2, 4, 6, 8, 10, 12, 14));
	private final ArrayList<Integer> cannotConnectEast = new ArrayList<Integer>(
			Arrays.asList(0, 1, 4, 5, 8, 9, 12, 13));
	private final ArrayList<Integer> cannotConnectSouth = new ArrayList<Integer>(
			Arrays.asList(0, 1, 2, 3, 8, 9, 10, 11));
	private final ArrayList<Integer> cannotConnectWest = new ArrayList<Integer>(
			Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7));
	// canConnectX are useful for when something is set, so the adjacent places
	// *must* connect
	private final ArrayList<Integer> canConnectNorth = new ArrayList<Integer>(
			Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15));
	private final ArrayList<Integer> canConnectEast = new ArrayList<Integer>(
			Arrays.asList(2, 3, 6, 7, 10, 11, 14, 15));
	private final ArrayList<Integer> canConnectSouth = new ArrayList<Integer>(
			Arrays.asList(4, 5, 6, 7, 12, 13, 14, 15));
	private final ArrayList<Integer> canConnectWest = new ArrayList<Integer>(
			Arrays.asList(8, 9, 10, 11, 12, 13, 14, 15));

	/**
	 * @param a
	 * @param b
	 * @return ArrayList<Integer>
	 */
	private ArrayList<Integer> Intersection(ArrayList<Integer> a, ArrayList<Integer> b) {
		ArrayList<Integer> newArr = new ArrayList<Integer>();
		for (Integer i : a)
			if (b.contains(i))
				newArr.add(i);
		return newArr;
	}

	/**
	 * @param a
	 * @param direction
	 * @param canConnect
	 * @return ArrayList<Integer>
	 */
	private ArrayList<Integer> Intersection(ArrayList<Integer> a, int direction, boolean canConnect) {
		if (direction % 2 != 0 && direction != 1)
			throw new IllegalArgumentException();

		if (canConnect) {
			switch (direction) {
				case 1:
					return Intersection(a, canConnectSouth);
				case 2:
					return Intersection(a, canConnectWest);
				case 4:
					return Intersection(a, canConnectNorth);
				case 8:
					return Intersection(a, canConnectEast);
			}
		} else {
			switch (direction) {
				case 1:
					return Intersection(a, cannotConnectSouth);
				case 2:
					return Intersection(a, cannotConnectWest);
				case 4:
					return Intersection(a, cannotConnectNorth);
				case 8:
					return Intersection(a, cannotConnectEast);
			}
		}
		throw new IllegalArgumentException();
	}

	/*
	 * Directions #s:
	 * North = 1 (0001)
	 * East = 2 (0010)
	 * South = 4 (0100)
	 * West = 8 (1000)
	 * 
	 * UP IS Y - 1
	 * DOWN IS Y + 1
	 * LEFT IS X - 1
	 * RIGHT IS X + 1
	 * 
	 * Room #s:
	 * Empty = 0 (0000)
	 * + = 15 (1111)
	 * 
	 * T (WNE) = 11 (1011)
	 * T (NES) = 7 (0111)
	 * T (ESW) = 14 (1110)
	 * T (SWN) = 13 (1101)
	 * 
	 * L (NE) = 3 (0011)
	 * L (ES) = 6 (0110)
	 * L (SW) = 12 (1100)
	 * L (WN) = 9 (1001)
	 * 
	 * End (N) = 1 (0001)
	 * End (E) = 2 (0010)
	 * End (S) = 4 (0100)
	 * End (W) = 8 (1000)
	 * 
	 * | (NS) = 5 (0101)
	 * - (EW) = 10 (1010)
	 */

	public MapGenerator(int width, int height) {
		this.map = new int[height][width];
		this.isSet = new boolean[height][width];
		this.generatingMap = new Object[height][width];
		this.height = height;
		this.width = width;
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++) {
				ArrayList<Integer> arr = new ArrayList<Integer>(this.middlePossible);
				if (i == 0)
					arr = this.Intersection(arr, this.cannotConnectNorth);
				if (i == height - 1)
					arr = this.Intersection(arr, this.cannotConnectSouth);
				if (j == 0)
					arr = this.Intersection(arr, this.cannotConnectWest);
				if (j == width - 1)
					arr = this.Intersection(arr, this.cannotConnectEast);
				this.generatingMap[i][j] = arr;
			}

		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				this.map[i][j] = -1;

		// starts the thing by setting the bottom left to 0 (empty)
		Coords bottomLeft = new Coords(0, height - 1);
		this.generatingMap[height - 1][0] = new ArrayList<Integer>(Arrays.asList(0));
		this.map[height - 1][0] = 0;
		this.isSet[height - 1][0] = true;
		this.stack.add(bottomLeft);

		while (!this.isCollapsed) {
			this.Iterate();
			this.isCollapsed = this.IsCollapsed();
		}

		GetRidOfDeadEnds();

		// for visualization for now
		String[][] pretty = Prettify(this.map);
		Integer[][] newMap = new Integer[map.length][map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				newMap[i][j] = Integer.valueOf(map[i][j]);
				pretty[i][j] += " " + newMap[i][j];
			}
		}
		String[] arrayNames = new String[this.width];
		for (int i = 0; i < arrayNames.length; i++) {
			arrayNames[i] = " ";
		}
		JFrame frame = new JFrame();
		JTable table = new JTable(pretty, arrayNames);

		frame.add(table);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void GetRidOfDeadEnds() {
		int[][] biggest = FindLongestConnections();
		int max = 0;
		for (int i = 0; i < biggest.length; i++)
			for (int j = 0; j < biggest[0].length; j++)
				if (biggest[i][j] > max)
					max = biggest[i][j];

		for (int i = 0; i < biggest.length; i++)
			for (int j = 0; j < biggest[0].length; j++)
				if (biggest[i][j] != max)
					map[i][j] = 0;
	}

	private int[][] FindLongestConnections() {
		int[][] biggest = new int[height][width];
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				FindLongestPathFromNode(col, row, biggest);
			}
		}
		return biggest;
	}

	private void FindLongestPathFromNode(int x, int y, int[][] biggestMap) {
		boolean[][] beenVisited = new boolean[height][width];
		int count = 0;
		ArrayList<Coords> queue = new ArrayList<>();
		ArrayList<Coords> setInCluster = new ArrayList<>();
		queue.add(new Coords(x, y));
		while (!(queue.isEmpty())) {
			Coords coords = queue.remove(0);
			setInCluster.add(coords);
			System.out.println(count);
			int[] neighbors = GetNeighborDirections(coords);
			y = coords.y;
			x = coords.x;
			int roomNum = map[y][x];
			beenVisited[y][x] = true;
			for (int i : neighbors) {
				switch (i) {
					case 0:
						if (!(((roomNum & 1) == 0) || (beenVisited[y - 1][x]))) {
							count++;
							beenVisited[y - 1][x] = true;
							queue.add(new Coords(x, y - 1));
						}
						break;
					case 1:
						if (!(((roomNum & 2) == 0) || (beenVisited[y][x + 1]))) {
							count++;
							beenVisited[y][x + 1] = true;
							queue.add(new Coords(x + 1, y));
						}
						break;
					case 2:
						if (!(((roomNum & 4) == 0) || (beenVisited[y + 1][x]))) {
							count++;
							beenVisited[y + 1][x] = true;
							queue.add(new Coords(x, y + 1));
						}
						break;
					case 3:
						if (!(((roomNum & 8) == 0) || (beenVisited[y][x - 1]))) {
							count++;
							beenVisited[y][x - 1] = true;
							queue.add(new Coords(x - 1, y));
						}
						break;
				}
			}
		}
		for (Coords coords : setInCluster) {
			biggestMap[coords.y][coords.x] = count;
		}
	}

	private int[] GetNeighborDirections(Coords coords) {
		int neighbors = 4;
		if (coords.isBottom || coords.isTop)
			neighbors--;
		if (coords.isLeft || coords.isRight)
			neighbors--;
		return GetNeighborDirections(coords, neighbors);
	}

	public boolean IsMapInvalid() {
		if (((this.map[height - 1][1] & 8) != 0) && ((this.map[height - 1][0] & 2) == 0))
			return true;
		else
			return false;
	}

	/**
	 * @param map
	 * @return String[][]
	 */
	private String[][] Prettify(int[][] map) {
		String[][] connections = new String[map.length][map[0].length];

		for (int y = 0; y < connections.length; y++) {
			for (int x = 0; x < connections[0].length; x++) {
				int index = map[y][x];
				String total = "";
				if ((index & 1) != 0)
					total += "^";
				if ((index & 2) != 0)
					total += ">";
				if ((index & 4) != 0)
					total += "V";
				if ((index & 8) != 0)
					total += "<";
				connections[y][x] = total;
			}
		}

		return connections;
	}

	/**
	 * @return boolean
	 */
	private boolean IsCollapsed() {
		for (int i = 0; i < this.height; i++)
			for (int j = 0; j < this.width; j++)
				if (!this.isSet[i][j])
					return false;
		return true;
	}

	/**
	 * @return int[]
	 */
	private int[] FindLeastEntropy() {
		int[] returns = new int[2];
		int lowest = Integer.MAX_VALUE;

		for (int i = 0; i < this.height; i++)
			for (int j = 0; j < this.width; j++) {
				ArrayList<Integer> arr = GetArrayListFromPoint(new Coords(j, i));
				if (arr.size() <= 1)
					continue;
				if (arr.size() < lowest) {
					lowest = arr.size();
					returns[0] = j;
					returns[1] = i;
				} else if (arr.size() == lowest)
					if (Math.random() >= 0.5) {
						lowest = arr.size();
						returns[0] = j;
						returns[1] = i;
					}
			}
		if (lowest == Integer.MAX_VALUE) {
			return null;
		}
		return returns;
	}

	/**
	 * @param coordinates
	 */
	private void CollapseRandom(Coords coordinates) {
		ArrayList<Integer> poss = GetArrayListFromPoint(coordinates);
		int index = (int) (Math.random() * poss.size());
		int roomNum = -1;
		try {
			roomNum = poss.get(index);
		} catch (Exception e) {
			System.out.println("Error! Coordinates were " + coordinates.x + ", " + coordinates.y);
		}

		this.map[coordinates.y][coordinates.x] = roomNum;
		this.isSet[coordinates.y][coordinates.x] = true;
		this.generatingMap[coordinates.y][coordinates.x] = new ArrayList<Integer>(
				Arrays.asList(roomNum));
	}

	private void Iterate() {
		if (this.stack.isEmpty()) {
			int[] coords = this.FindLeastEntropy();
			if (coords == null)
				return;
			Coords coordinateClass = new Coords(coords[0], coords[1]);

			this.CollapseRandom(coordinateClass);
			this.stack.addLast(coordinateClass);
		}
		while (!this.stack.isEmpty()) {
			Coords propCoords = this.stack.removeLast();
			this.Propagate(propCoords);
		}
	}

	/**
	 * @param pCoords
	 */
	private void Propagate(Coords pCoords) {
		int neighbors = 4;
		if (pCoords.isTop || pCoords.isBottom)
			neighbors--;
		if (pCoords.isLeft || pCoords.isRight)
			neighbors--;

		Coords[] neighborList = new Coords[neighbors];
		int[] neighborDir = new int[neighbors];
		int x = pCoords.x;
		int y = pCoords.y;
		GetNeighborList(pCoords, neighbors, neighborList, x, y);
		neighborDir = GetNeighborDirections(pCoords, neighbors);

		ArrayList<Integer> possible = GetArrayListFromPoint(pCoords);
		if (possible.size() == 1) {
			int number = possible.get(0);
			PropagateSingle(neighbors, neighborList, neighborDir, number);
		} else {
			PropagateMultiple(neighbors, neighborList, neighborDir, possible);
		}
	}

	/**
	 * @param pCoords
	 * @return ArrayList<Integer>
	 */
	private ArrayList<Integer> GetArrayListFromPoint(Coords pCoords) {
		@SuppressWarnings("unchecked")
		ArrayList<Integer> list = (ArrayList<Integer>) this.generatingMap[pCoords.y][pCoords.x];
		return list;
	}

	/**
	 * @param neighbors
	 * @param neighborList
	 * @param neighborDir
	 * @param possible
	 */
	private void PropagateMultiple(int neighbors, Coords[] neighborList, int[] neighborDir,
			ArrayList<Integer> possible) {
		boolean[] arrays = MultiPossibleDirectionCheck(possible);
		boolean[] only = Arrays.copyOfRange(arrays, 0, 4);
		boolean[] directions = Arrays.copyOfRange(arrays, 4, 8);
		for (int i = 0; i < neighbors; i++) {
			int neighborDirection = neighborDir[i];
			if (!(only[neighborDirection]))
				continue;
			else {
				boolean canConnect = directions[neighborDirection];
				int direction = 1 << neighborDir[i];
				PropagateDirect(neighborList, i, direction, canConnect);
			}
		}
	}

	/**
	 * @param neighbors
	 * @param neighborList
	 * @param neighborDir
	 * @param number
	 */
	private void PropagateSingle(int neighbors, Coords[] neighborList, int[] neighborDir, int number) {
		for (int i = 0; i < neighbors; i++) {
			int direction = 1 << neighborDir[i];
			boolean canConnect = ((number & direction) != 0);
			PropagateDirect(neighborList, i, direction, canConnect);
		}
	}

	/**
	 * @param neighborList
	 * @param i
	 * @param direction
	 * @param canConnect
	 */
	private void PropagateDirect(Coords[] neighborList, int i, int direction, boolean canConnect) {
		Coords coordinates = neighborList[i];
		int nx = coordinates.x;
		int ny = coordinates.y;
		ArrayList<Integer> poss = GetArrayListFromPoint(coordinates);
		ArrayList<Integer> newArr = Intersection(poss, direction, canConnect);
		if (newArr.equals(poss))
			return;
		if (newArr.size() == 1) {
			this.isSet[ny][nx] = true;
			this.map[ny][nx] = newArr.get(0);
		}
		this.generatingMap[ny][nx] = newArr;
		if (!(this.isSet[ny][nx] || StackAlreadyContains(coordinates)))
			stack.addLast(coordinates);
	}

	/**
	 * @param pCoords
	 * @param neighbors
	 * @return int[]
	 */
	private int[] GetNeighborDirections(Coords pCoords, int neighbors) {
		int[] neighborDir = new int[neighbors];
		if (neighbors == 4) {
			neighborDir = new int[] { 0, 1, 2, 3 };
		} else if (neighbors == 3) {
			if (pCoords.isTop) {
				neighborDir = new int[] { 1, 2, 3 };
			} else if (pCoords.isRight) {
				neighborDir = new int[] { 0, 2, 3 };
			} else if (pCoords.isBottom) {
				neighborDir = new int[] { 0, 1, 3 };
			} else if (pCoords.isLeft) {
				neighborDir = new int[] { 0, 1, 2 };
			}
		} else {
			if (pCoords.isTop && pCoords.isRight) {
				neighborDir = new int[] { 2, 3 };
			} else if (pCoords.isTop && pCoords.isLeft) {
				neighborDir = new int[] { 1, 2 };
			} else if (pCoords.isBottom && pCoords.isRight) {
				neighborDir = new int[] { 0, 3 };
			} else if (pCoords.isBottom && pCoords.isLeft) {
				neighborDir = new int[] { 0, 1 };
			}
		}
		return neighborDir;
	}

	/**
	 * @param pCoords
	 * @param neighbors
	 * @param neighborList
	 * @param x
	 * @param y
	 */
	private void GetNeighborList(Coords pCoords, int neighbors, Coords[] neighborList, int x, int y) {
		if (neighbors == 4) {
			neighborList[0] = new Coords(x, y - 1);
			neighborList[1] = new Coords(x + 1, y);
			neighborList[2] = new Coords(x, y + 1);
			neighborList[3] = new Coords(x - 1, y);
		} else if (neighbors == 3) {
			if (pCoords.isTop) {
				neighborList[0] = new Coords(x + 1, y);
				neighborList[1] = new Coords(x, y + 1);
				neighborList[2] = new Coords(x - 1, y);
			} else if (pCoords.isRight) {
				neighborList[0] = new Coords(x, y - 1);
				neighborList[1] = new Coords(x, y + 1);
				neighborList[2] = new Coords(x - 1, y);
			} else if (pCoords.isBottom) {
				neighborList[0] = new Coords(x, y - 1);
				neighborList[1] = new Coords(x + 1, y);
				neighborList[2] = new Coords(x - 1, y);
			} else if (pCoords.isLeft) {
				neighborList[0] = new Coords(x, y - 1);
				neighborList[1] = new Coords(x + 1, y);
				neighborList[2] = new Coords(x, y + 1);
			}
		} else {
			if (pCoords.isTop && pCoords.isRight) {
				neighborList[0] = new Coords(x, y + 1);
				neighborList[1] = new Coords(x - 1, y);
			} else if (pCoords.isTop && pCoords.isLeft) {
				neighborList[0] = new Coords(x + 1, y);
				neighborList[1] = new Coords(x, y + 1);
			} else if (pCoords.isBottom && pCoords.isRight) {
				neighborList[0] = new Coords(x, y - 1);
				neighborList[1] = new Coords(x - 1, y);
			} else if (pCoords.isBottom && pCoords.isLeft) {
				neighborList[0] = new Coords(x, y - 1);
				neighborList[1] = new Coords(x + 1, y);
			}
		}
	}

	/**
	 * @param possible
	 * @return boolean[]
	 */
	private boolean[] MultiPossibleDirectionCheck(ArrayList<Integer> possible) {
		boolean[] returned = new boolean[8];
		for (int i = 0; i < 4; i++) {
			int first = possible.get(0);
			returned[i] = true;
			returned[i + 4] = ((first & (1 << i)) != 0);
			for (int j = 1; j < possible.size(); j++) {
				int num = possible.get(j);
				boolean canConnect = ((num & (1 << i)) != 0);
				if (canConnect != returned[i + 4]) {
					returned[i] = false;
					break;
				}
			}
		}
		return returned;
	}

	/**
	 * @param coordinates
	 * @return boolean
	 */
	private boolean StackAlreadyContains(Coords coordinates) {
		for (Iterator<Coords> i = stack.iterator(); i.hasNext();) {
			Coords coords = i.next();
			if (coords.equals(coordinates))
				return true;
		}
		return false;
	}
}