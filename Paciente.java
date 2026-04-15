public class Paciente {
    public String nombreCompleto;
    private String identificacion;
    private String tipoSeguro;
    private int edad;
    private double costoConsulta;
    private int numeroConsultas;
    private int prioridadMedica;

    public Paciente(String nombreCompleto, String identificacion, String tipoSeguro, int edad, double costoConsulta, int numeroConsultas, int prioridadMedica) {
        this.nombreCompleto = nombreCompleto;
        this.identificacion = identificacion;
        this.tipoSeguro = tipoSeguro;
        setEdad(edad);
        setCostoConsulta(costoConsulta);
        setNumeroConsultas(numeroConsultas);
        setPrioridadMedica(prioridadMedica);
    }

    public void setEdad(int edad) {
        if (edad > 0) this.edad = edad;
    }

    public void setCostoConsulta(double costoConsulta) {
        if (costoConsulta > 0) this.costoConsulta = costoConsulta;
    }

    public void setNumeroConsultas(int numeroConsultas) {
        if (numeroConsultas >= 0) this.numeroConsultas = numeroConsultas;
    }

    public void setPrioridadMedica(int prioridadMedica) {
        if (prioridadMedica >= 1 && prioridadMedica <= 5) {
            this.prioridadMedica = prioridadMedica;
        }
    }

    public double calcularDescuento() {
        double subtotal = costoConsulta * numeroConsultas;
        if (tipoSeguro.equalsIgnoreCase("Basico")) return subtotal * 0.10;
        else if (tipoSeguro.equalsIgnoreCase("Premium")) return subtotal * 0.20;
        else return 0.0;
    }

    public double calcularCostoTotal() {
        double subtotal = costoConsulta * numeroConsultas;
        return subtotal - calcularDescuento();
    }

    public String obtenerClasificacionPrioridad() {
        if (prioridadMedica >= 4) return "Alta prioridad";
        else if (prioridadMedica >= 2) return "Prioridad media";
        else return "Prioridad baja";
    }

    public String generarMensajeMedico() {
        String clasificacion = obtenerClasificacionPrioridad();
        if (clasificacion.equals("Alta prioridad")) return "Atención inmediata requerida";
        else if (clasificacion.equals("Prioridad media")) return "Seguimiento necesario";
        else return "Control regular";
    }

    public void mostrarReporte() {
        System.out.println("--- Reporte Médico ---");
        System.out.println("Paciente: " + nombreCompleto + " | ID: " + identificacion);
        System.out.println("Edad: " + edad + " | Seguro: " + tipoSeguro);
        System.out.println("Nivel de Prioridad: " + prioridadMedica + " (" + obtenerClasificacionPrioridad() + ")");
        System.out.println("Mensaje Clínico: " + generarMensajeMedico());
        System.out.println("Consultas: " + numeroConsultas + " a $" + costoConsulta + " c/u");
        System.out.println("Descuento aplicado: $" + calcularDescuento());
        System.out.println("Costo Total a Pagar: $" + calcularCostoTotal());
        System.out.println("----------------------\n");
    }
}