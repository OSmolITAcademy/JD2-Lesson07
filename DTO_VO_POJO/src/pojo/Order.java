package pojo;

import java.util.List;


/*���������� ��������� �������� �������. 
� ����� �������� ���� ���-��������� � ������ ����������, ������� ������������ ������. 
����� ������������ ����� ��������� �����-������ �����. 
��� ����� ��� ����� ��������� ��� ��������: �������� ������ ������ � ������� � ����������� �����.

��� ����, ����� ��� �������, �� ������� ���������� ����� ������������ ����� Order.

POJO - ���� ����� �������� � ���� ������ � ������ �� ���������. 
�� �� ����������� �� ������-���� �������������� ������ �� ��������� ���������� ��� �� ������-���� ���������� ������ 
� �������� ���������� ������� - Plain Old Java Object.
POJO - ��� ������ � ��������� �������-��������� ������-������. 
��� ��������, POCO �������� ������ ���� � ������, � ������. 
����� "Plain Old" �����-���� ���������� ��� ��� �������� ������� ��������� �� ������������ ������������ �� �������� ����������� 
�� ���������� (����� ������������ �� EntityObject � ������ Entity Framework). 
�.�. ���� ������� - "���������� �� ������� ����-�����-������ ���������� �� ����������, � �� ��������, ���� ������ ������ ������� �������".*/


public class Order {
	private ItemDiscountService itemDiscountService;
	private UserService userService;

	public Order(ItemDiscountService itemDiscountService, UserService userService) {
		this.itemDiscountService = itemDiscountService;
		this.userService = userService;
	}

	private int id;
	private List<Item> items;
	private double subtotal;
	private double discount;

	public ItemDiscountService getItemDiscountService() {
		return itemDiscountService;
	}

	public void setItemDiscountService(ItemDiscountService itemDiscountService) {
		this.itemDiscountService = itemDiscountService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public void addItem(Item item) {
		items.add(item);
		calculateSubtotalAndDiscount();
	}

	public void calculateSubtotalAndDiscount() {
		double subtotal = 0;
		double discount = 0;

		for (Item item : items) {
			double currentCost = item.getCost() * itemDiscountService.getDiscountFactor(item)
					* userService.getCurrentUserDiscountFactor();
			subtotal += currentCost;
			discount += item.getCost() - currentCost;
		}

		this.subtotal = subtotal;
		this.discount = discount;
	}
}




