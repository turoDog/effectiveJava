package one;

public class Test {

	public static void main(String[] args) {
		// Providers would execute these lines
		Services.registerDefaultProvider(DEFAULT_PROVIDER);
		Services.registerProvider("comp", COMP_PROVIDER);
		Services.registerProvider("armed", ARMED_PROVIDER);
		
		//Clinets would execute these lines
		Service s1 = Services.newInstance();
		Service s2 = Services.newInstance("comp");
		Service s3 = Services.newInstance("armed");
		System.out.printf("%s, %s, %s%n", s1, s2, s3);
	}
	
	private static Provider DEFAULT_PROVIDER = new Provider() {
		
		@Override
		public Service newService() {
			return new Service() {
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "Default service";
				}
			};
		}
	};
	
	private static Provider COMP_PROVIDER = new Provider() {
		
		@Override
		public Service newService() {
			// TODO Auto-generated method stub
			return new Service() {
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "Complementary service";
				}
			};
		}
	};
		
	private static Provider ARMED_PROVIDER = new Provider() {
		
		@Override
		public Service newService() {
			// TODO Auto-generated method stub
			return new Service() {
				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return "Armed service";
				}
			};
		}
	};

}
