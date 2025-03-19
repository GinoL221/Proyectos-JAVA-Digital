import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ProductSingle hamburger = new ProductSingle("Hamburger", 5.0);
        ProductSingle fries = new ProductSingle("Fries", 2.0);
        ProductSingle soda = new ProductSingle("Soda", 1.0);

        BurgerJoint burgerJoint = new BurgerJoint();

        burgerJoint.addProduct(hamburger);
        burgerJoint.addProduct(fries);
        burgerJoint.addProduct(soda);

        System.out.println("Total price: " + burgerJoint.calculateCartPrice());

        ProductComposite combo = new ProductComposite("Combo-1", 0.15);

        combo.addProduct(hamburger);
        combo.addProduct(fries);
        combo.addProduct(soda);

        System.out.println("Price "+ combo.getName() +": " + combo.calculatePrice());

        burgerJoint.addProduct(combo);

        ProductComposite megaProductComposite = new ProductComposite("Mega Combo", 0.25);

        megaProductComposite.addProduct(combo);
        megaProductComposite.addProduct(combo);
        megaProductComposite.addProduct(combo);
        megaProductComposite.addProduct(fries);
        megaProductComposite.addProduct(soda);

        System.out.println("Price "+ megaProductComposite.getName() +": " + megaProductComposite.calculatePrice());

        burgerJoint.addProduct(megaProductComposite);
        System.out.println("Total price: " + burgerJoint.calculateCartPrice());
    }
}