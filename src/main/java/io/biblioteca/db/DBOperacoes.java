package io.biblioteca.db;

import io.biblioteca.Livro;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class DBOperacoes {

    public Livro salvar(Livro livro) {

        Transaction transaction = null;

        try(Session session = DBSessaoFactory.build().openSession()) {

            transaction = session.beginTransaction();
            session.save(livro);
            transaction.commit();

        } catch (Exception ex) {

            if(transaction != null) {
                transaction.rollback();
            }

            ex.printStackTrace();
        }

        return livro;
    }

    public List<Livro> pesquisarDisponiveis() {

        try (Session session = DBSessaoFactory.build().openSession()) {
            return session.createQuery("from " + Livro.class.getSimpleName(), Livro.class).list();
        }
    }

    public Livro pesquisarPorNumero(Long numero) {

        try (Session session = DBSessaoFactory.build().openSession()) {
            return session.get(Livro.class, numero);
        }
    }
}
