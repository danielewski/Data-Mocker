import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Mocker {

	/* 	I Understand much of this is not in good practice
		I created this program to quickly mock data for import into my SQL database for class
	*/

	// Integers to change how many entries to create
	static int companyCreations = 10000;
	static int employeeCreations = 80000;
	static int industryCreations = 1000;
	static int locationCreations = 10000;
	static int productCreations = 35000;

	// The arrays used to create tuples from the keys for the some relations
	public static String[] companiesKey = new String[companyCreations];
	public static String[] employeesKey = new String[employeeCreations];
	public static String[] industriesKey = new String[industryCreations];
	public static String[] locationsKey = new String[locationCreations];
	public static String[] productsKey = new String[productCreations];

	
	public static void main(String[] args) throws IOException {
		companyCreate(companyCreations);
		employeeCreate(employeeCreations);
		industryCreate(industryCreations);
		locationCreate(locationCreations);
		productCreate(productCreations);
		belongsToCreate();
		hiresCreate();
		residesInCreate();
		sellsCreate();
	}

	public static String randomStringWithLength(int length) {
		//values to be chosen from for the string
		char[] values = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		String str = "";
		// builds random string
		for (int i = 0; i < length; i++) {
			int nextChar = (int) (Math.random() * 26);
			str = str + values[nextChar];
		}

		return str;
	}

	public static String randomString(int maxLength, int minLength) {
		char[] values = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		int length = (int) (Math.random() * (maxLength - minLength + 1) + minLength);
		String str = "";
		//builds the randomized string
		for (int i = 0; i < length; i++) {
			int nextChar = (int) (Math.random() * 26);
			str = str + values[nextChar];
		}
		return str;
	}

	public static String randomEmployeeName(int maxLength) {
		char[] values = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		int lastLength = (int) (Math.random() * (maxLength / 2 - 4) + 3);
		int firstLength = (int) (Math.random() * (maxLength / 2 - 4) + 3);
		String str = "";
		// create first name
		for (int i = 0; i < firstLength; i++) {
			int nextChar = (int) (Math.random() * 26);
			str = str + values[nextChar];
		}
		str = str + " ";
		// create last name
		for (int i = 0; i < lastLength; i++) {
			int nextChar = (int) (Math.random() * 26);
			str = str + values[nextChar];
		}

		return str;
	}

	public static String randomIndustryName(int maxLength) {
		char[] values = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		int length = (int) (Math.random() * (maxLength - 4) + 3);

		String str = "";
		// builds industry name
		for (int i = 0; i < length; i++) {
			int nextChar = (int) (Math.random() * 26);
			str = str + values[nextChar];
		}

		return str;
	}

	public static String randomSector(int length) {
		char[] values = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };

		String str = "";
		// builds sector name
		for (int i = 0; i < length; i++) {
			int nextChar = (int) (Math.random() * 26);
			str = str + values[nextChar];
		}

		return str;
	}

	public static String randomInt(int length) {
		//builds as a string so zeros at front aren't removed
		String number = "";
		for (int i = 0; i < length; i++) {
			int nextNum = (int) (Math.random() * 10);
			number = number + nextNum;
		}
		return number;
	}

	public static String randomAge() {
		String age = "";
		//creates random age from 1 to 36 and tacks "months" on the end
		int ageNum = (int) (Math.random() * 36 + 1);
		age = ageNum + " Months";
		return age;
	}

	public static String randomPosition() {
		//chooses random position from the array
		String[] positions = { "CEO", "CTO", "CFO", "COO", "CMO", "HR", "Software Engineer", "Marketing",
				"Data Engineer", "Salesman", "Finance", "Accountant", "Engineer", "Web Developer", "Intern", "Manager",
				"Secretary", "Janitor", "Supervisor", "Electrician", "Advertisor", "Analyst", "Attorney", "Clerk",
				"Geologist", "Geographer", "Cook", "Chef" };
		int i = (int) (Math.random() * positions.length);
		String position = positions[i];
		return position;
	}

	public static String randomProdType() {
		//chooses random product type from the array
		String[] products = { "Service", "Goods", "Information", "Technology", "Food", "Paper", "Cleaning",
				"Automotive", "Woodworking", "Beverage", "Clothing", "Jewelry", "Furniture", "Kitchen", "Beauty",
				"Medical" };
		int i = (int) (Math.random() * products.length);
		String position = products[i];
		return position;
	}

	public static String randomAddress() {
		//builds an address with a 4 digit street number, 6 char street name, and "street"
		String address = "";
		address = address + randomInt(4) + " " + randomStringWithLength(6) + " Street";
		return address;
	}

	// creates companyNum different companies and adds them to a file
	public static void companyCreate(int companyNum) throws IOException {
		BufferedWriter writer = new BufferedWriter(
				new FileWriter("companyData.csv"));
		HashMap<Boolean, String> phoneMap = new HashMap<Boolean, String>();

		for (int i = 0; i < companyNum; i++) {

			// create new company name with max length of 15 and min length of 4
			String name = randomString(15, 4);

			// creates new 10 digit phone number
			String phone = randomInt(10);

			// since it is a primary key, it must not be duplicated.
			// store in hashmap to check that the number does not already exist
			// if number does exist, calls randomInt until we get a new one
			while (phoneMap.containsValue(phone)) {
				phone = randomInt(10);
			}
			phoneMap.put(true, phone);
			companiesKey[i] = phone;

			// creates a random age for company, up to 30 months old
			String age = randomAge();
			writer.write(name + "," + phone + "," + age);
			writer.newLine();
		}
		writer.close();
		System.out.println("Company Data Created, " + companyNum + " entries located in file companyData.csv");
	}

	public static void employeeCreate(int employeeNum) throws IOException {
		BufferedWriter writer = new BufferedWriter(
				new FileWriter("employeeData.csv"));
		HashMap<Boolean, String> ssnMap = new HashMap<Boolean, String>();

		for (int i = 0; i < employeeNum; i++) {

			// create new employee name, total max length of 18 chars
			String name = randomEmployeeName(18);

			String position = randomPosition();

			// creates a random age for employee, from 18 to 70 years old
			int age = (int) (Math.random() * 52 + 18);

			// creates new 9 digit ssn
			String ssn = randomInt(9);

			// since it is a primary key, it must not be duplicated.
			// store in hashmap to check that the number does not already exist
			// if number does exist, calls randomInt until we get a new one
			while (ssnMap.containsValue(ssn)) {
				ssn = randomInt(9);
			}
			ssnMap.put(true, ssn);
			employeesKey[i] = ssn;

			writer.write(name + "," + position + "," + age + "," + ssn);
			writer.newLine();
		}
		writer.close();
		System.out.println("Employee Data Created, " + employeeNum + " entries located in file employeeData.csv");
	}

	public static void industryCreate(int industryNum) throws IOException {
		BufferedWriter writer = new BufferedWriter(
				new FileWriter("industryData.csv"));
		HashMap<Boolean, String> sectorIDMap = new HashMap<Boolean, String>();

		for (int i = 0; i < industryNum; i++) {

			// create new industry name with max length of 15
			String name = randomIndustryName(15);

			// creates new 3 char sector
			String sector = randomSector(3);

			// creates random sectorID
			String sectorID = randomInt(4);
			// since it is a primary key, it must not be duplicated.
			// store in hashmap to check that the number does not already exist
			// if number does exist, calls sectorID until we get a new one
			while (sectorIDMap.containsValue(sectorID)) {
				sectorID = randomInt(4);
			}
			sectorIDMap.put(true, sectorID);
			industriesKey[i] = sectorID;

			writer.write(name + "," + sector + "," + sectorID);
			writer.newLine();
		}
		writer.close();
		System.out.println("Industry Data Created, " + industryNum + " entries located in file industryData.csv");
	}

	public static void locationCreate(int locationNum) throws IOException {
		BufferedWriter writer = new BufferedWriter(
				new FileWriter("locationData.csv"));
		HashMap<Boolean, String> sectorIDMap = new HashMap<Boolean, String>();

		for (int i = 0; i < locationNum; i++) {

			// create new random address
			String address = randomAddress();

			// creates new zip code
			String zip = randomInt(5);

			String locID = randomInt(6);
			// since it is a primary key, it must not be duplicated.
			// store in hashmap to check that the number does not already exist
			// if number does exist, calls sectorID until we get a unique one
			while (sectorIDMap.containsValue(locID)) {
				locID = randomInt(4);
			}
			sectorIDMap.put(true, locID);
			locationsKey[i] = locID;

			writer.write(address + "," + zip + "," + locID);
			writer.newLine();
		}
		writer.close();
		System.out.println("Location Data Created, " + locationNum + " entries located in file locationData.csv");
	}

	public static void productCreate(int productNum) throws IOException {
		BufferedWriter writer = new BufferedWriter(
				new FileWriter("productData.csv"));
		HashMap<Boolean, String> productIDMap = new HashMap<Boolean, String>();
		for (int i = 0; i < productNum; i++) {

			// chooses a product type
			String type = randomProdType();

			// creates random product name between 5 and 12 chars
			String name = randomString(12, 5);

			String productID = randomInt(6);
			// since it is a primary key, it must not be duplicated.
			// store in hashmap to check that the number does not already exist
			// if number does exist, calls productID until we get a unique one
			while (productIDMap.containsValue(productID)) {
				productID = randomInt(4);
			}
			productIDMap.put(true, productID);
			productsKey[i] = productID;

			writer.write(type + "," + name + "," + productID);
			writer.newLine();
		}
		writer.close();
		System.out.println("Product Data Created, " + productNum + " entries located in file productData.csv");
	}

	// company and industry relation
	public static void belongsToCreate() throws IOException {
		BufferedWriter writer = new BufferedWriter(
				new FileWriter("belongsToData.csv"));
		for (int i = 0; i < companiesKey.length; i++) {
			// industries dont need to be double checked, many companies can be in the same
			// industry
			int randIndustry = (int) (Math.random() * industriesKey.length);
			writer.write(companiesKey[i] + "," + industriesKey[randIndustry]);
			writer.newLine();
		}
		writer.close();
		System.out.println(
				"BelongsTo Data Created, " + companiesKey.length + " entries located in file belongsToData.csv");
	}

	// company and employees relation
	public static void hiresCreate() throws IOException {
		BufferedWriter writer = new BufferedWriter(
				new FileWriter("hiresData.csv"));
		for (int i = 0; i < employeesKey.length; i++) {
			// companies dont need to be unique, many employees can be in the same company
			int randCompany = (int) (Math.random() * companiesKey.length);
			writer.write(companiesKey[randCompany] + "," + employeesKey[i]);
			writer.newLine();
		}
		writer.close();
		System.out.println("Hires Data Created, " + employeesKey.length + " entries located in file hiresData.csv");
	}

	// company and location relation
	public static void residesInCreate() throws IOException {
		BufferedWriter writer = new BufferedWriter(
				new FileWriter("residesInData.csv"));
		for (int i = 0; i < companiesKey.length; i++) {
			// locations dont need to be unique, many companies can be in the same location
			int randLocation = (int) (Math.random() * locationsKey.length);
			writer.write(companiesKey[i] + "," + locationsKey[randLocation]);
			writer.newLine();
		}
		writer.close();
		System.out.println(
				"ResidesIn Data Created, " + companiesKey.length + " entries located in file residesInData.cvs");
	}

	// company and product relation
	public static void sellsCreate() throws IOException {
		BufferedWriter writer = new BufferedWriter(
				new FileWriter("sellsData.csv"));
		for (int i = 0; i < productsKey.length; i++) {
			// companies dont need to be unique, many products can be sold by the same
			// company
			int randCompany = (int) (Math.random() * companiesKey.length);
			writer.write(companiesKey[randCompany] + "," + productsKey[i]);
			writer.newLine();
		}
		writer.close();
		System.out.println("Sells Data Created, " + productsKey.length + " entries located in file sellsData.csv");
	}
}
