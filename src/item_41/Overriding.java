package item_41;

	class Wine {
		String name() {
			return "wine";
		}
	}	
	
	class SparklineWine extends Wine {
		@Override
		String name() {
			return "sparkling wine";
		}
	}
	
	class Champagne extends SparklineWine {
		@Override
		String name () {
			return "champagne";
		}
	}
	
	public class Overriding {
		public static void main(String[] args) {
			Wine[] wines = { new Wine(), new SparklineWine(), new Champagne() };
			for (Wine wine : wines)
				System.out.println(wine.name());
		}
	}

