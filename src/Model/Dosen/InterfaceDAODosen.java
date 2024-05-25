
package Model.Dosen;

import java.util.List;

/**
 *
 * @author USER
 */
public interface InterfaceDAODosen {
    public void insert(ModelDosen dosen);
    
    public void update(ModelDosen dosen);
    
    public void delete(int id);
    
    public List<ModelDosen> getAll();
}