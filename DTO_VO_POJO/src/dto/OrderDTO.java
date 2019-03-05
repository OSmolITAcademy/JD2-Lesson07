package dto;

/*Когда пользователь добавляет что-то в корзину, эта информация передаётся на сервер приложений, что вызывает метод 
addItem в классе Order, который пересчитывает стоимость товаров и скидку, меняя тем самым состояние заказа. 

Нужно отобразить пользователю это изменение, и для этого нужно передать обновлённое состояние обратно на клиент.

Но мы не можем просто передать экземпляр нашего Order или его копию, так как он зависит от других классов 
(ItemDiscountService, UserService), которые в свою очередь могут зависеть от других классов, 
которым может быть нужно соединение с базой данных и т. п.

Конечно, их можно продублировать на клиенте, но тогда на клиенте будет доступна вся наша логика, 
строка подключения к БД и т. п., чего мы показывать совершенно не хотим. 

Поэтому, чтобы просто передать обновленное состояние, мы можем сделать для этого специальный класс OrderDTO.

Мы сможем поместить в него те данные, которые хотим передать на клиент, создав тем самым Data Transfer Object. 

В нем могут содержаться совершенно любые нужные нам атрибуты. В том числе и те, которых нет в классе Order, например, атрибут total.

DTO — это класс с данными, но без логики. Он используется для передачи данных между слоями приложения 
и между приложениями, для сериализации и аналогичных целей.

*/

public class OrderDTO {

	private int id;
	private double subtotal;
	private double discount;
	private double total;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
