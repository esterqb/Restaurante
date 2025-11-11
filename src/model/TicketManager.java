package model;

import java.util.ArrayList;
import java.util.List;

public class TicketManager {
    private static TicketManager instance;
    private List<Plato> pedido;

    private TicketManager() {
        pedido = new ArrayList<>();
    }

    public static TicketManager getInstance() {
        if (instance == null) {
            instance = new TicketManager();
        }
        return instance;
    }

    public void addPlato(Plato p) {
        // Si el plato ya existe, actualiza cantidad/comentario
        for (Plato existente : pedido) {
            if (existente.getNombre().equals(p.getNombre())) {
                existente.setCantidad(p.getCantidad());
                existente.setComentario(p.getComentario());
                return;
            }
        }
        pedido.add(p);
    }

    public List<Plato> getPedido() {
        return pedido;
    }

    public void clear() {
        pedido.clear();
    }
}
