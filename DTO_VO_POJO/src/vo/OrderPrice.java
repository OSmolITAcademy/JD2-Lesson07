package vo;


/*� ������� ������ ���� ���� ������������� - id, ������� �� ���������� ��� ����, ����� �������� ���� ����� �� �������. 
� �� ����� ��� � ������ ������� ���������� ����� ������������ ����� � id=1, ���������� � ���� 3 ��������, 
� �� ����� �������� ����� �� �����, � ��� �� ���������������, �� ���������� � ���� 5 ���������. 
����� ����� ����������, ���� �� ��������� ��������� ������ �� �� � �������� ��� � ������, �� �������� ��������� � ��.

����������, ��� �������� �� ��, ��� ��������� �������� � ������ � �� � ������ � ������ ������� ���������� ����� ����������, 
��� ��� ����� ����� ���� � ��� �� ������, ��� ��� �� �������������� ���������.

� ���� ������� �������� ��������� - 100, ����� �������������� - 1, ������� ����, ��� �������� ������������ - "��������" 
����� ����� ����������� ��������� ������ �����, ����� ��� �������� ����� ��������� ���������, � ����� �����.
�. �. 100 ����� ���� ����� ������ 100, "��������" ����� ���� ����� ������ "��������" � �. �. 
� �������, ��� ����� ������� ��� �������. 
���� �� �������� ����� ��������� ��������� - ��� ����� �����. ����� ������� ���������� Value Object.

� ����� ������� �� ����� �� ������� ��� OrderPrice � ��������� ���� ���� subtotal, total � discount.

VO � ��� �����, ������� ��������������� �� ��������. 
����� ������ ������������� ������ �������������, �� ������ ����� ���������� ��������� �� ����� �������.
�������� VO �������� ����� �����, ������� ��������� ��������� ����� ��������� ������������ � �� ������.

Value Objects - ��� ������ ������������� ��������� ��������� ��������, ��� ������� ��� ������� ����������� �����. 
��������, ����, �����, ������. Value Objects - ��� �� ��������������� ��������. 
��� "���������" ��� ���������� �������-���������.
Value Object ������������ ��� ��������. ��� ��������������� ���, ����� DateTime. 
� �� �� ����� ���� POJO, �� ����������� - �.�. �� ������������ �� ���� ��������, 
�� � ����� ��, ���������� ������������� "����� ���������� ������������" ��� ValueObjects ������� �� �����������, 
��� ��� ���������� "������� �������" �� ������ �� ��������.
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
