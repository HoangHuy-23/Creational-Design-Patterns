package buoi02.exercise01.decorator;


class OrderServiceDecorator implements OrderService {
    protected OrderService decoratedService;

    public OrderServiceDecorator(OrderService service) {
        this.decoratedService = service;
    }

    public void process() {
        decoratedService.process();
    }
}