import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//订单状态枚举
enum OrderStatus {
    CREATE, PAID, SHIPPING, DELIVERED, CANCEL
}

//客户
class Customer {
    private String name;
    private String contact;
    private String deliveryAddress;
    private Boolean active;
    private List<Order> orderList = new ArrayList<>();

    public Customer(String name, String contact, String deliveryAddress, Boolean active) {
        this.name = name;
        this.contact = contact;
        this.deliveryAddress = deliveryAddress;
        this.active = active;
    }

    public void addOrder(Order o) {
        orderList.add(o);
        o.setCustomer(this);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    public List<Order> getOrderList() { return orderList; }
}

//商品
class Product {
    private String title;
    private Double weight;
    private String description;

    public Product(String title, Double weight, String description) {
        this.title = title;
        this.weight = weight;
        this.description = description;
    }

    public Double getPriceForQuantity(Integer qty) {
        return 99.9 * qty;
    }
    public Double getWeight() { return weight; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public void setWeight(Double weight) { this.weight = weight; }
}

//订单详情
class OrderDetail {
    private Integer quantity;
    private Product product;

    public OrderDetail(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public Double calculateSubTotal() {
        return product.getPriceForQuantity(quantity);
    }
    public Double calculateWeight() {
        return product.getWeight() * quantity;
    }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}

//支付抽象父类
abstract class Payment {
    private Double amount;

    public Payment(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
}

//信用卡支付
class Credit extends Payment {
    private String number;
    private String type;
    private Date expireDate;

    public Credit(Double amount, String number, String type, Date expireDate) {
        super(amount);
        this.number = number;
        this.type = type;
        this.expireDate = expireDate;
    }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Date getExpireDate() { return expireDate; }
    public void setExpireDate(Date expireDate) { this.expireDate = expireDate; }
}

//现金支付
class Cash extends Payment {
    private Double cashTendered;

    public Cash(Double amount, Double cashTendered) {
        super(amount);
        this.cashTendered = cashTendered;
    }

    public Double getCashTendered() { return cashTendered; }
    public void setCashTendered(Double cashTendered) { this.cashTendered = cashTendered; }
}

//订单
public class Order {
    private Date createDate;
    private OrderStatus status;
    private Customer customer;
    private List<OrderDetail> detailList = new ArrayList<>();
    private Payment payment;

    public Order(Date createDate, OrderStatus status) {
        this.createDate = createDate;
        this.status = status;
    }

    public void addOrderDetail(OrderDetail od) {
        detailList.add(od);
    }

    public void setCustomer(Customer customer) { this.customer = customer; }
    public Date getCreateDate() { return createDate; }
    public void setCreateDate(Date createDate) { this.createDate = createDate; }
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }
    public Customer getCustomer() { return customer; }
    public List<OrderDetail> getDetailList() { return detailList; }
    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment) { this.payment = payment; }
}
