import java.util.regex.Matcher;
import java.util.regex.Pattern;

String direccionEmail = "example@mail.com"
Pattern patron = Pattern.compile(".+@.+(\\.[a-z]+)+");
Matcher match = patron.matcher(direccionEmail);

match.matches();
