import java.util.Vector;

public class Contigous {
	public Vector<Integer> bitVector = new Vector<Integer>();
	public Vector<File> structure = new Vector<File>();
	public Vector<String> path = new Vector<String>();

	// public Vector<String> toPrint = new Vector<String>();

	Contigous(int sizee) {
		File ob = new File();
		for (int i = 0; i < sizee; i++) {
			bitVector.add(0);
		}
		ob.name = "<root>";
		ob.pathh = "<root>";
		ob.parent = "";
		ob.blocks = 0;
		ob.sizee = 0;
		structure.add(ob);
		// toPrint.add("<root>");

	}

	public void createFile(String name, int sizee) {
		File object = new File();
		int c = 0;
		String[] arr;
		Vector<Integer> counter = new Vector<Integer>();
		Vector<Integer> indexes = new Vector<Integer>();
		arr = name.split("/");
		if (path.contains(name)) {
			System.out.println("ALREADY EXISTS");
		} else {
			path.add(name);
			object.pathh = name;
			object.name = arr[arr.length - 1];
			object.parent = arr[arr.length - 2];

			int x;
			for (x = 0; x < bitVector.size(); x++) {

				if (bitVector.get(x) == 0) {
					c++;

				} else {
					counter.add(c);
					indexes.add(x - c);
					c = 0;
				}

			}
			counter.add(c);
			indexes.add(x - c);
			c = 0;

			int c1 = 0;
			int index = 0;
			for (int i = 0; i < counter.size(); i++) {

				c1 = counter.get(0);
				if (counter.get(i) > c1) {
					c1 = counter.get(i);
					index = i;
				}

			}
			System.out.println("TAKE BLOCK OF: " + c1 + " ZEROES"
					+ " and INDEX " + indexes.get(index));

			for (int i = indexes.get(index); i < indexes.get(index) + sizee; i++) {
				// System.out.println("****************");

				bitVector.set(i, 1);

			}
			object.blocks = c1;
			object.index = indexes.get(index);
			String a = "";
			for (int i = 0; i < arr.length; i++) {
				a += " ";
			}
			a += arr[arr.length - 1];
			// toPrint.add(a);
			for (int i = 0; i < structure.size(); i++) {
				// System.out.println("====="+structure.get(i).name +"  "+
				// arr[arr.length-2]);
				if (structure.get(i).name.equals("<" + arr[arr.length - 2]
						+ ">")) {
					// System.out.println("HERE");
					object.sizee = sizee;
					structure.add(i + 1, object);
					// structure.insertElementAt(object, i);

				}

			}

		}
	}
}