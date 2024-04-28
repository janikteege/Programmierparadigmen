// Zusammenarbeit: Janik Teege, Nele Hüsemann

class BadAnimals {

	public static void main(String[] args) {
		Animal a = new Animal();
		Dog d = new Dog();
		Cat c = new Cat();
		Bird b = new Bird();
		Cheetah ch = new Cheetah();
		Sloth s = new Sloth();
		
        a.move();
        b.move();
        d.move();
        c.move();
        ch.move();
        s.move();
	}
}
		

class Animal {
    public void move() {
        System.out.println("I'm an Animal, I just move.");
    }
}

class Dog extends Animal {
	public void move() {
		System.out.println("Dogs run.");
	}
}

class Cat extends Animal {
	public void move() {
		System.out.println("Cats tiptoe.");
	}
}

class Bird extends Animal {
	public void move() {
		System.out.println("Birds fly.");
	}
}

class Cheetah extends Animal {
	public void move() {
		System.out.println("Cheetah sprint.");
	}
}

class Sloth extends Animal {
	public void move() {
		System.out.println("Sloths don't move!");
	}
}