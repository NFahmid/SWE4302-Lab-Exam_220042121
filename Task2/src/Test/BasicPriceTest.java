package Test;

import Source.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicPriceTest {
    @Test
    public void testBasicPrice(){
        List<IceCreamFlavor> scoops = List.of(new MintChocolateChip(), new ChocolateFudge());
        List<Topping> toppings = List.of(new Sprinkles(), new CrushedOreo());
        Serving serving = new WaffleCone();

        BasicPricing basicPricing = new BasicPricing();
        double subtotal = basicPricing.calculateSubtotal(scoops, toppings, serving);
        assertEquals(11.2, subtotal, 0.01);
    }

    @Test
    public void testApplyTax(){
        BasicPricing basicPricing = new BasicPricing();
        double tax = basicPricing.applyTax(11.2);
        assertEquals(11.2 * 1.08, tax, 0.01);
    }
}