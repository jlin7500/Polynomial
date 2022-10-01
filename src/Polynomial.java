import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 A class to represent a polynomial.
 */
public class Polynomial
{
    private LinkedList<Term> polynomial;

    /**
     Constructs an empty polynomial
     */
    public Polynomial()
    {
        polynomial = new LinkedList<Term>();

    }

    /**
     Constructs a new polynomial with the given term
     @param t the term to initialize the polynomial with
     */
    public Polynomial(Term t)
    {
        this();
        polynomial = new LinkedList<Term>();
        polynomial.add(t);
    }

    /**
     Adds the polynomial such that the terms are in sorted order from highest power to lowest
     @param p the polynomial to add
     */
    public void add(Polynomial p)
    {

        boolean test = true;
        int val = 0;
        Term varTerm;

        for (Term termToAdd : p.polynomial)
        {
            ListIterator<Term> iter = polynomial.listIterator();

            while(test && val < polynomial.size())
            {
                varTerm = polynomial.get(val);

                if(varTerm.getPower() == termToAdd.getPower())
                {
                    varTerm.addIfSamePower(termToAdd);
                    test = true;
                }
                else if(termToAdd.getPower() > varTerm.getPower())
                {
                    polynomial.add(val,new Term(termToAdd.getCoefficient(),termToAdd.getPower()));
                    test = false;
                }
                val++;
            }
            if(true)
            {
                polynomial.add(new Term(termToAdd.getCoefficient(), termToAdd.getPower()));
            }
        }

    }

    /**
     Multiplies the given polynomial with this one and returns the result
     @param p the polynomial to multiply
     @return this * p
     */
    public Polynomial multiply(Polynomial p)
    {
        Polynomial result = new Polynomial();

        // to do: your code here
        for(Term term1: p.polynomial)
        {
            for(Term term2: polynomial)
            {
                Term term3 = term1.multiply(term2);
                result.add(new Polynomial(term3));
            }
        }

        return result;
    }

    /**
     Prints the polynomial "nicely" so that it reads from highest term to lowest and doesn't have a leading "+" if the first term is positive.
     */
    public void print()
    {
        String print = "";
        int counter = 0;
        for (Term t : polynomial)
        {
            // to do: your code here
            if(t.getCoefficient() > 0)
            {
                    print = print + " + ";

            }
            else
            {
                print = print + " - ";
            }
            print = print + t.toString();
            System.out.println(print);
        }
    }
}