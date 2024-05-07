import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        
        CalculationThread thread1 = new CalculationThread(2024, 2023);
        CalculationThread thread2 = new CalculationThread(2023, 2024);
        CalculationThread thread3 = new CalculationThread(2020, 2025);

      
        thread1.start();
        thread2.start();
        thread3.start();

        try {
           
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       
        BigInteger result = thread1.getResult().add(thread2.getResult()).add(thread3.getResult());
        System.out.println("Сумма результатов: " + result);
    }
}

class CalculationThread extends Thread {
    private int base;
    private int power;
    private BigInteger result;

    public CalculationThread(int base, int power) {
        this.base = base;
        this.power = power;
    }

    @Override
    public void run() {
        
        result = BigInteger.valueOf(base).pow(power);
        System.out.println("Поток " + getId() + ": " + base + "^" + power + " = " + result);
    }

    public BigInteger getResult() {
        return result;
    }
}