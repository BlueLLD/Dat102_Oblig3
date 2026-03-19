void main() {
	Person p1 = new Person("Arne", "sage", "tulle", "smile", "lese");
	Person p2 = new Person("Britt", "kartlesing", "tulle", "smile", "lese");
	Person p3 = new Person("Bob Europa", "kartlesing", "blindeskrift", "kappgang",
			"naruto");

	IO.println("Match med samme person:");
	IO.println(Person.match(p1, p1));
	IO.println();
	IO.println("Match med p1 og p2:");
	IO.println(Person.match(p1, p2));
	IO.println(Person.match(p2, p1));
	IO.println();
	IO.println("Match med p2 og p3:");
	IO.println(Person.match(p2, p3));
	IO.println(Person.match(p3, p2));
	IO.println();
	IO.println("Match med p1 og p3:");
	IO.println(Person.match(p1, p3));
	IO.println(Person.match(p3, p1));
}