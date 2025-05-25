package practice.solution.designpatterns.behavioral.observer;

public class GrabStocks {

	public static void main(String[] args) {

		StockGrabber stockGrabber = new StockGrabber();

		StockObserver observer1 = new StockObserver(stockGrabber);

		stockGrabber.setIBMPrice(197.0);
		stockGrabber.setAAPLPrice(677.6);
		stockGrabber.setGOOGLPrice(676.4);

		StockObserver observer2 = new StockObserver(stockGrabber);

		stockGrabber.setIBMPrice(197.0);
		stockGrabber.setAAPLPrice(677.6);
		stockGrabber.setGOOGLPrice(676.4);

		stockGrabber.unRegister(observer1);

		stockGrabber.setIBMPrice(197.0);
		stockGrabber.setAAPLPrice(677.6);
		stockGrabber.setGOOGLPrice(676.4);

	}

}
