package singleton;

public class SingletonSerializedTest {
    public static void main(String[] args) {
        BillPughSingleton instanceOne = BillPughSingleton.getInstance();
        BillPughSingleton instanceTwo = BillPughSingleton.getInstance();
        System.out.println("Bill Pugh Singleton: " + (instanceOne == instanceTwo));

        LazyInitializedSingleton instanceThree = LazyInitializedSingleton.getInstance();
        LazyInitializedSingleton instanceFour = LazyInitializedSingleton.getInstance();
        System.out.println("Lazy Initialized Singleton: " + (instanceThree == instanceFour));

        EagerInitializedSingleton instanceFive = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton instanceSix = EagerInitializedSingleton.getInstance();
        System.out.println("Eager Initialized Singleton: " + (instanceFive == instanceSix));

        EnumSingleton instanceSeven = EnumSingleton.INSTANCE;
        EnumSingleton instanceEight = EnumSingleton.INSTANCE;
        System.out.println("Enum Singleton: " + (instanceSeven == instanceEight));
    }
}
