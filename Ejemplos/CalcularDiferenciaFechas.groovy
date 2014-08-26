import java.text.SimpleDateFormat
import java.util.Calendar


SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Date inicio = sdf.parse("04/06/2013");
Date fin = sdf.parse("04/05/2013");


/*
fin.after(inicio)*/

// Crear 2 instancias de Calendar
Calendar cal1 = Calendar.getInstance();
Calendar cal2 = Calendar.getInstance();

// Establecer las fechas
cal1.set(2013, 06, 04);
cal2.set(2013, 06, 04);

// conseguir la representacion de la fecha en milisegundos
long milis1 = cal1.getTimeInMillis();
long milis2 = cal2.getTimeInMillis();

// calcular la diferencia en milisengundos
long diff = milis2 - milis1;

// calcular la diferencia en segundos
long diffSeconds = diff / 1000;

// calcular la diferencia en minutos
long diffMinutes = diff / (60 * 1000);

// calcular la diferencia en horas
long diffHours = diff / (60 * 60 * 1000);

// calcular la diferencia en dias
long diffDays = diff / (24 * 60 * 60 * 1000);

println("En milisegundos: " + diff + " milisegundos.");
println("En segundos: " + diffSeconds + " segundos.");
println("En minutos: " + diffMinutes + " minutos.");
println("En horas: " + diffHours + " horas.");
println("En dias: " + diffDays + " dias.");