
/**
 A class to to test the Polynomial class.
 */
public class PolynomialTester
{
    public static void main(String[] args)
    {
        Polynomial p = new Polynomial(new Term(-10, 0));
        p.add(new Polynomial(new Term(-1, 1)));
        p.add(new Polynomial(new Term(9, 7)));
        p.add(new Polynomial(new Term(5, 10)));

        Polynomial q = p.multiply(p);
        q.print();

        /**
         Try some examples:
         for above example your output must be:
         100.0 + 20.0x + 1.0x^2 - 180.0x^7 - 18.0x^8 - 100.0x^10 - 10.0x^11 + 81.0x^14
         + 90.0x^17 + 25.0x^20
         */

        // try different examples and print output: for example: p = x^2-10X + 1 and q = x^3 + 5x - 20
        // print p and q and print p*q

    }
}
