open module dev.kalenchukov.names
{
	requires java.sql;
	requires org.jetbrains.annotations;
	requires org.xerial.sqlitejdbc;

	exports dev.kalenchukov.names;
	exports dev.kalenchukov.names.entities;
	exports dev.kalenchukov.names.exceptions;
}