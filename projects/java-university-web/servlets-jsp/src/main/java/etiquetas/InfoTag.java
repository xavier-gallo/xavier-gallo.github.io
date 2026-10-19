package etiquetas;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class InfoTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String mensaje = "<div>"
                       + "<h2>Universidad DAD2</h2>"
                       + "<p>Bienvenido al panel de administración. Hoy es <strong>" + fecha + "</strong>.</p>"
                       + "</div>";
        getJspContext().getOut().write(mensaje);
    }
}
