package bad.robot.refactoring.chapter1;

public class Rental {

    Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

	public double getChargeFor() {
		double amount = 0;
		switch (getMovie().getPriceCode()) {
		    case Movie.REGULAR:
		        amount += 2;
		        if (getDaysRented() > 2)
		            amount += (getDaysRented() - 2) * 1.5;
		        break;
		    case Movie.NEW_RELEASE:
		        amount += getDaysRented() * 3;
		        break;
		    case Movie.CHILDREN:
		        amount += 1.5;
		        if (getDaysRented() > 3)
		            amount += (getDaysRented() - 3) * 1.5;
		        break;
		}
		return amount;
	}
	
	public int calculateFrequentRenterPoints() {
		if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1)
			return 2;
		return 1;
	}
}
