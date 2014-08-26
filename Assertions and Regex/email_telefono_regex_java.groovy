import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Pattern patron = Pattern.compile(".+@.+\\..{2,3}")
Pattern patron = Pattern.compile(".+@.+(\\.[a-z]+)+")

Pattern patronTelefono = Pattern.compile("[0-9]{9,}");

Matcher match = patron.matcher("email@email.mx.com");
Matcher telefono = patronTelefono.matcher("012345678");

println match.matches()
println telefono.matches()