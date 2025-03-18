package buoi03.library.ex05;

interface BookBorrow {
    void borrow();
}

class BasicBookBorrow implements BookBorrow {
    @Override
    public void borrow() {
        System.out.println("Mượn sách bình thường.");
    }
}

abstract class BookBorrowDecorator implements BookBorrow {
    protected BookBorrow decoratedBookBorrow;

    public BookBorrowDecorator(BookBorrow decoratedBookBorrow) {
        this.decoratedBookBorrow = decoratedBookBorrow;
    }

    @Override
    public void borrow() {
        decoratedBookBorrow.borrow();
    }
}

class ExtendBorrowTime extends BookBorrowDecorator {
    public ExtendBorrowTime(BookBorrow decoratedBookBorrow) {
        super(decoratedBookBorrow);
    }

    @Override
    public void borrow() {
        super.borrow();
        System.out.println("Gia hạn thời gian mượn.");
    }
}

class SpecialEditionRequest extends BookBorrowDecorator {
    public SpecialEditionRequest(BookBorrow decoratedBookBorrow) {
        super(decoratedBookBorrow);
    }

    @Override
    public void borrow() {
        super.borrow();
        System.out.println("Yêu cầu sách với phiên bản đặc biệt.");
    }
}



public class Main {
	public static void main(String[] args) {
        // Mượn sách bình thường
        BookBorrow basicBorrow = new BasicBookBorrow();
        System.out.println("Trường hợp 1: Mượn sách cơ bản");
        basicBorrow.borrow();

        // Mượn sách + Gia hạn thời gian mượn
        BookBorrow extendedBorrow = new ExtendBorrowTime(new BasicBookBorrow());
        System.out.println("\nTrường hợp 2: Mượn sách + Gia hạn");
        extendedBorrow.borrow();

        // Mượn sách + Yêu cầu sách bản đặc biệt
        BookBorrow specialRequestBorrow = new SpecialEditionRequest(new BasicBookBorrow());
        System.out.println("\nTrường hợp 3: Mượn sách + Yêu cầu bản đặc biệt");
        specialRequestBorrow.borrow();

        // Mượn sách + Gia hạn + Yêu cầu bản đặc biệt
        BookBorrow fullOptionBorrow = new SpecialEditionRequest(new ExtendBorrowTime(new BasicBookBorrow()));
        System.out.println("\nTrường hợp 4: Mượn sách + Gia hạn + Yêu cầu bản đặc biệt");
        fullOptionBorrow.borrow();
    }
}
