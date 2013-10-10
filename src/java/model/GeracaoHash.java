package model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author curso
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.UsuarioDao;
import model.entities.Usuario;

public class GeracaoHash {

    public String gerarHash(String tipo, String senha) throws NoSuchAlgorithmException {

        if (tipo.equals("MD5")) {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(senha.getBytes());
            byte[] hashMd5 = md5.digest();
            System.out.println(exibe(hashMd5));
            return exibe(hashMd5);
        } else if (tipo.equals("MD2")) {
            MessageDigest md2 = MessageDigest.getInstance("MD2");
            md2.update(senha.getBytes());
            byte[] hashMd2 = md2.digest();
            System.out.println(exibe(hashMd2));
            return exibe(hashMd2);
        } else if (tipo.equals("SHA1")) {
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            sha1.update(senha.getBytes());
            byte[] hashSha1 = sha1.digest();
            System.out.println(exibe(hashSha1));
            return exibe(hashSha1);
        } else if (tipo.equals("SHA256")) {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            sha256.update(senha.getBytes());
            byte[] hashSha1 = sha256.digest();
            System.out.println(exibe(hashSha1));
            return exibe(hashSha1);
        } else if (tipo.equals("SHA384")) {
            MessageDigest sha384 = MessageDigest.getInstance("SHA-384");
            sha384.update(senha.getBytes());
            byte[] hashSha1 = sha384.digest();
            System.out.println(exibe(hashSha1));
            return exibe(hashSha1);
        } else {
            MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
            sha512.update(senha.getBytes());
            byte[] hashSha1 = sha512.digest();
            System.out.println(exibe(hashSha1));
            return exibe(hashSha1);
        }
    }

    private String exibe(byte[] bytes) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
            int parteBaixa = bytes[i] & 0xf;
            if (parteAlta == 0) {
                s.append('0');
            }
            s.append(Integer.toHexString(parteAlta | parteBaixa));
        }
        return s.toString();
    }

    /**
     *
     * @param usuario
     * @return retorna true se o login for válido
     */
    public boolean validaLogin(String nomeUsuario, String senha, String hash) {

        UsuarioDao userDao = new UsuarioDao();
        Usuario usuario = null;
        try {
            usuario = userDao.findUsuario(nomeUsuario);
        } catch (Exception ex) {
            Logger.getLogger(GeracaoHash.class.getName()).log(Level.SEVERE, null, ex);
        }


        try {
            if (usuario != null) {
                String senhaHash = null;
                senhaHash = gerarHash(hash, senha);
                if (usuario.getNomeUsuario().equals(nomeUsuario)
                        && usuario.getSenhaUsuario().equals(senhaHash)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GeracaoHash.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
