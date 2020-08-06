package myPack;

public class CurrConvertor
{
	public double dollarToINR(double dollar) throws NumberFormatException
	{
		if(dollar < 0)
			throw new NumberFormatException();

		return dollar * 71.81;
	}

	public double yenToINR(double yen) throws NumberFormatException
	{
		if(yen < 0)
			throw new NumberFormatException();

		return yen * 0.67;
	}

	public double euroToINR(double euro) throws NumberFormatException
	{
		if(euro < 0)
			throw new NumberFormatException();

		return euro * 79.39;
	}
}
