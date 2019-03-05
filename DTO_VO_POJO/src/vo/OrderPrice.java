package vo;


/*У каждого заказа есть свой идентификатор - id, который мы используем для того, чтобы отличать один заказ от другого. 
В то время как в памяти сервера приложений может существовать заказ с id=1, содержащий в себе 3 предмета, 
в БД может хранится такой же заказ, с тем же идентификатором, но содержащий в себе 5 предметов. 
Такое может возникнуть, если мы прочитали состояние заказа из БД и поменяли его в памяти, не сохранив изменения в БД.

Получается, что несмотря на то, что некоторые значения у заказа в БД и заказа в памяти сервера приложений будут отличаться, 
это все равно будет один и тот же объект, так как их идентификаторы совпадают.

В свою очередь значение стоимости - 100, номер идентификатора - 1, текущая дата, имя текущего пользователя - "Петрович" 
будут равны аналогичным значениям только тогда, когда эти значения будут полностью совпадать, и никак иначе.
Т. е. 100 может быть равно только 100, "Петрович" может быть равен только "Петрович" и т. д. 
И неважно, где будут созданы эти объекты. 
Если их значения будут полностью совпадать - они будут равны. Такие объекты называются Value Object.

В нашем примере мы можем бы создать тип OrderPrice и поместить туда поля subtotal, total и discount.

VO — это класс, который идентифицирутся по значению. 
Такие классы рекомендуется делать неизменяемыми, но иногда жизнь заставляет отступать от этого правила.
Примером VO является любой класс, который реализует равенство через равенство содержащихся в нём данных.

Value Objects - это способ представления логически целостных объектов, для которых нет готовых стандартных типов. 
Например, даты, время, деньги. Value Objects - это не самостоятельные сущности. 
Это "кирпичики" для построения классов-сущностей.
Value Object использутеся где придется. Это вспомогательный тип, вроде DateTime. 
И он не может быть POJO, по определению - т.к. не представляет из себя сущность, 
да и опять же, повального использования "новых новомодных суперклассов" для ValueObjects никогда не наблюдалось, 
так что становится "старыми добрыми" им просто не пришлось.
*/

public class OrderPrice {

	private double subtotal;
	private double discount;
	private double total;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(subtotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderPrice other = (OrderPrice) obj;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		if (Double.doubleToLongBits(subtotal) != Double.doubleToLongBits(other.subtotal))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}

}
