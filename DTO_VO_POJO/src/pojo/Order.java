package pojo;

import java.util.List;


/*ѕредставим некоторый интернет магазин. 
” этого магазина есть веб-интерфейс и сервер приложений, который обрабатывает логику. 
Ќекий пользователь хочет совершить какой-нибудь заказ. 
ƒл€ этого ему нужно выполнить р€д действий: добавить нужные товары в корзину и подтвердить заказ.

ƒл€ того, чтобы это сделать, на сервере приложений может существовать класс Order.

POJO - этот класс содержит в себе данные и логику их изменени€. 
ќн не унаследован от какого-либо специфического класса из сторонней библиотеки или от какого-либо стороннего класса 
и €вл€етс€ достаточно простым - Plain Old Java Object.
POJO - это подход к написанию классов-сущностей бизнес-логики. 
 ак сущности, POCO содержат внутри себ€ и данные, и логику. 
„асть "Plain Old" всего-лишь показывает что дл€ создани€ классов сущностей не используетс€ наследование от т€желого суперкласса 
из фреймворка (вроде наследовани€ от EntityObject в старом Entity Framework). 
“.е. суть подхода - "испольютс€ не суровые мега-пупер-модные мегаклассы из фреймворка, а по старинке, тупо старые добрые обычные объекты".*/


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




