public class Vendedor {
    public String nombre;
    public String area;
    private double montoVendido;
    private double porcentajeComision;
    private double cumplimientoMeta;

    public Vendedor(String nombre, String area, double montoVendido, double porcentajeComision, double cumplimientoMeta) {
        this.nombre = nombre;
        this.area = area;
        setMontoVendido(montoVendido);
        setPorcentajeComision(porcentajeComision);
        setCumplimientoMeta(cumplimientoMeta);
    }

    public void setMontoVendido(double montoVendido) {
        if (montoVendido >= 0) this.montoVendido = montoVendido;
    }

    public void setPorcentajeComision(double porcentajeComision) {
        if (porcentajeComision >= 0) this.porcentajeComision = porcentajeComision;
    }

    public void setCumplimientoMeta(double cumplimientoMeta) {
        if (cumplimientoMeta >= 0) this.cumplimientoMeta = cumplimientoMeta;
    }

    public double calcularComision() {
        return montoVendido * (porcentajeComision / 100);
    }

    public double calcularIngresoTotal() {
        return montoVendido + calcularComision();
    }

    public String obtenerEstadoCumplimiento() {
        if (cumplimientoMeta >= 90) return "Excelente";
        else if (cumplimientoMeta >= 70) return "Aceptable";
        else return "Bajo";
    }

    public String obtenerMensajeFinal() {
        String estado = obtenerEstadoCumplimiento();
        if (estado.equals("Excelente")) return "Vendedor con desempeño sobresaliente";
        else if (estado.equals("Aceptable")) return "Vendedor con desempeño aceptable";
        else return "Se requiere seguimiento comercial";
    }

    public void mostrarReporte() {
        System.out.println("--- Reporte de Ventas ---");
        System.out.println("Vendedor: " + nombre + " | Área: " + area);
        System.out.println("Monto Vendido: $" + montoVendido);
        System.out.println("Comisión Generada: $" + calcularComision());
        System.out.println("Ingreso Total: $" + calcularIngresoTotal());
        System.out.println("Cumplimiento: " + cumplimientoMeta + "% (" + obtenerEstadoCumplimiento() + ")");
        System.out.println("Mensaje: " + obtenerMensajeFinal());
        System.out.println("-------------------------\n");
    }
}