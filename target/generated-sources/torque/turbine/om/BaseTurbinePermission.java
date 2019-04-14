package turbine.om;


import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.torque.TorqueException;
import org.apache.torque.map.TableMap;
import org.apache.torque.om.BaseObject;
import org.apache.torque.om.ComboKey;
import org.apache.torque.om.DateKey;
import org.apache.torque.om.NumberKey;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.om.StringKey;
import org.apache.torque.om.Persistent;
import org.apache.torque.util.Criteria;
import org.apache.torque.util.Transaction;





/**
 * This class was autogenerated by Torque on:
 *
 * [Sun Apr 14 22:50:48 IST 2019]
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to TurbinePermission
 */
public abstract class BaseTurbinePermission extends BaseObject
{
    /** Serial version */
    private static final long serialVersionUID = 1555262448106L;

    /** The Peer class */
    private static final TurbinePermissionPeer peer =
        new TurbinePermissionPeer();


    /** The value for the permissionId field */
    private int permissionId;

    /** The value for the name field */
    private String name;


    /**
     * Get the PermissionId
     *
     * @return int
     */
    public int getPermissionId()
    {
        return permissionId;
    }


    /**
     * Set the value of PermissionId
     *
     * @param v new value
     */
    public void setPermissionId(int v) throws TorqueException
    {

        if (this.permissionId != v)
        {
            this.permissionId = v;
            setModified(true);
        }



        // update associated TurbineRolePermission
        if (collTurbineRolePermissions != null)
        {
            for (int i = 0; i < collTurbineRolePermissions.size(); i++)
            {
                ((TurbineRolePermission) collTurbineRolePermissions.get(i))
                        .setPermissionId(v);
            }
        }
    }

    /**
     * Get the Name
     *
     * @return String
     */
    public String getName()
    {
        return name;
    }


    /**
     * Set the value of Name
     *
     * @param v new value
     */
    public void setName(String v) 
    {

        if (!ObjectUtils.equals(this.name, v))
        {
            this.name = v;
            setModified(true);
        }


    }

       


    /**
     * Collection to store aggregation of collTurbineRolePermissions
     */
    protected List<TurbineRolePermission> collTurbineRolePermissions;

    /**
     * Temporary storage of collTurbineRolePermissions to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initTurbineRolePermissions()
    {
        if (collTurbineRolePermissions == null)
        {
            collTurbineRolePermissions = new ArrayList<TurbineRolePermission>();
        }
    }


    /**
     * Method called to associate a TurbineRolePermission object to this object
     * through the TurbineRolePermission foreign key attribute
     *
     * @param l TurbineRolePermission
     * @throws TorqueException
     */
    public void addTurbineRolePermission(TurbineRolePermission l) throws TorqueException
    {
        getTurbineRolePermissions().add(l);
        l.setTurbinePermission((TurbinePermission) this);
    }

    /**
     * Method called to associate a TurbineRolePermission object to this object
     * through the TurbineRolePermission foreign key attribute using connection.
     *
     * @param l TurbineRolePermission
     * @throws TorqueException
     */
    public void addTurbineRolePermission(TurbineRolePermission l, Connection con) throws TorqueException
    {
        getTurbineRolePermissions(con).add(l);
        l.setTurbinePermission((TurbinePermission) this);
    }

    /**
     * The criteria used to select the current contents of collTurbineRolePermissions
     */
    private Criteria lastTurbineRolePermissionsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getTurbineRolePermissions(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<TurbineRolePermission> getTurbineRolePermissions()
        throws TorqueException
    {
        if (collTurbineRolePermissions == null)
        {
            collTurbineRolePermissions = getTurbineRolePermissions(new Criteria(10));
        }
        return collTurbineRolePermissions;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this TurbinePermission has previously
     * been saved, it will retrieve related TurbineRolePermissions from storage.
     * If this TurbinePermission is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<TurbineRolePermission> getTurbineRolePermissions(Criteria criteria) throws TorqueException
    {
        if (collTurbineRolePermissions == null)
        {
            if (isNew())
            {
               collTurbineRolePermissions = new ArrayList<TurbineRolePermission>();
            }
            else
            {
                criteria.add(TurbineRolePermissionPeer.PERMISSION_ID, getPermissionId() );
                collTurbineRolePermissions = TurbineRolePermissionPeer.doSelect(criteria);
            }
        }
        else
        {
            // criteria has no effect for a new object
            if (!isNew())
            {
                // the following code is to determine if a new query is
                // called for.  If the criteria is the same as the last
                // one, just return the collection.
                criteria.add(TurbineRolePermissionPeer.PERMISSION_ID, getPermissionId());
                if (!lastTurbineRolePermissionsCriteria.equals(criteria))
                {
                    collTurbineRolePermissions = TurbineRolePermissionPeer.doSelect(criteria);
                }
            }
        }
        lastTurbineRolePermissionsCriteria = criteria;

        return collTurbineRolePermissions;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getTurbineRolePermissions(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<TurbineRolePermission> getTurbineRolePermissions(Connection con) throws TorqueException
    {
        if (collTurbineRolePermissions == null)
        {
            collTurbineRolePermissions = getTurbineRolePermissions(new Criteria(10), con);
        }
        return collTurbineRolePermissions;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this TurbinePermission has previously
     * been saved, it will retrieve related TurbineRolePermissions from storage.
     * If this TurbinePermission is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<TurbineRolePermission> getTurbineRolePermissions(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collTurbineRolePermissions == null)
        {
            if (isNew())
            {
               collTurbineRolePermissions = new ArrayList<TurbineRolePermission>();
            }
            else
            {
                 criteria.add(TurbineRolePermissionPeer.PERMISSION_ID, getPermissionId());
                 collTurbineRolePermissions = TurbineRolePermissionPeer.doSelect(criteria, con);
             }
         }
         else
         {
             // criteria has no effect for a new object
             if (!isNew())
             {
                 // the following code is to determine if a new query is
                 // called for.  If the criteria is the same as the last
                 // one, just return the collection.
                 criteria.add(TurbineRolePermissionPeer.PERMISSION_ID, getPermissionId());
                 if (!lastTurbineRolePermissionsCriteria.equals(criteria))
                 {
                     collTurbineRolePermissions = TurbineRolePermissionPeer.doSelect(criteria, con);
                 }
             }
         }
         lastTurbineRolePermissionsCriteria = criteria;

         return collTurbineRolePermissions;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this TurbinePermission is new, it will return
     * an empty collection; or if this TurbinePermission has previously
     * been saved, it will retrieve related TurbineRolePermissions from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in TurbinePermission.
     */
    protected List<TurbineRolePermission> getTurbineRolePermissionsJoinTurbineRole(Criteria criteria)
        throws TorqueException
    {
        if (collTurbineRolePermissions == null)
        {
            if (isNew())
            {
               collTurbineRolePermissions = new ArrayList<TurbineRolePermission>();
            }
            else
            {
                criteria.add(TurbineRolePermissionPeer.PERMISSION_ID, getPermissionId());
                collTurbineRolePermissions = TurbineRolePermissionPeer.doSelectJoinTurbineRole(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(TurbineRolePermissionPeer.PERMISSION_ID, getPermissionId());
            if (!lastTurbineRolePermissionsCriteria.equals(criteria))
            {
                collTurbineRolePermissions = TurbineRolePermissionPeer.doSelectJoinTurbineRole(criteria);
            }
        }
        lastTurbineRolePermissionsCriteria = criteria;

        return collTurbineRolePermissions;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this TurbinePermission is new, it will return
     * an empty collection; or if this TurbinePermission has previously
     * been saved, it will retrieve related TurbineRolePermissions from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in TurbinePermission.
     */
    protected List<TurbineRolePermission> getTurbineRolePermissionsJoinTurbinePermission(Criteria criteria)
        throws TorqueException
    {
        if (collTurbineRolePermissions == null)
        {
            if (isNew())
            {
               collTurbineRolePermissions = new ArrayList<TurbineRolePermission>();
            }
            else
            {
                criteria.add(TurbineRolePermissionPeer.PERMISSION_ID, getPermissionId());
                collTurbineRolePermissions = TurbineRolePermissionPeer.doSelectJoinTurbinePermission(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(TurbineRolePermissionPeer.PERMISSION_ID, getPermissionId());
            if (!lastTurbineRolePermissionsCriteria.equals(criteria))
            {
                collTurbineRolePermissions = TurbineRolePermissionPeer.doSelectJoinTurbinePermission(criteria);
            }
        }
        lastTurbineRolePermissionsCriteria = criteria;

        return collTurbineRolePermissions;
    }



        
    private static List<String> fieldNames = null;

    /**
     * Generate a list of field names.
     *
     * @return a list of field names
     */
    public static synchronized List<String> getFieldNames()
    {
        if (fieldNames == null)
        {
            fieldNames = new ArrayList<String>();
            fieldNames.add("PermissionId");
            fieldNames.add("Name");
            fieldNames = Collections.unmodifiableList(fieldNames);
        }
        return fieldNames;
    }

    /**
     * Retrieves a field from the object by field (Java) name passed in as a String.
     *
     * @param name field name
     * @return value
     */
    public Object getByName(String name)
    {
        if (name.equals("PermissionId"))
        {
            return new Integer(getPermissionId());
        }
        if (name.equals("Name"))
        {
            return getName();
        }
        return null;
    }

    /**
     * Set a field in the object by field (Java) name.
     *
     * @param name field name
     * @param value field value
     * @return True if value was set, false if not (invalid name / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByName(String name, Object value )
        throws TorqueException, IllegalArgumentException
    {
        if (name.equals("PermissionId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setPermissionId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Name"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setName((String) value);
            return true;
        }
        return false;
    }

    /**
     * Retrieves a field from the object by name passed in
     * as a String.  The String must be one of the static
     * Strings defined in this Class' Peer.
     *
     * @param name peer name
     * @return value
     */
    public Object getByPeerName(String name)
    {
        if (name.equals(TurbinePermissionPeer.PERMISSION_ID))
        {
            return new Integer(getPermissionId());
        }
        if (name.equals(TurbinePermissionPeer.PERMISSION_NAME))
        {
            return getName();
        }
        return null;
    }

    /**
     * Set field values by Peer Field Name
     *
     * @param name field name
     * @param value field value
     * @return True if value was set, false if not (invalid name / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByPeerName(String name, Object value)
        throws TorqueException, IllegalArgumentException
    {
      if (TurbinePermissionPeer.PERMISSION_ID.equals(name))
        {
            return setByName("PermissionId", value);
        }
      if (TurbinePermissionPeer.PERMISSION_NAME.equals(name))
        {
            return setByName("Name", value);
        }
        return false;
    }

    /**
     * Retrieves a field from the object by Position as specified
     * in the xml schema.  Zero-based.
     *
     * @param pos position in xml schema
     * @return value
     */
    public Object getByPosition(int pos)
    {
        if (pos == 0)
        {
            return new Integer(getPermissionId());
        }
        if (pos == 1)
        {
            return getName();
        }
        return null;
    }

    /**
     * Set field values by its position (zero based) in the XML schema.
     *
     * @param position The field position
     * @param value field value
     * @return True if value was set, false if not (invalid position / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByPosition(int position, Object value)
        throws TorqueException, IllegalArgumentException
    {
    if (position == 0)
        {
            return setByName("PermissionId", value);
        }
    if (position == 1)
        {
            return setByName("Name", value);
        }
        return false;
    }
     
    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.
     *
     * @throws TorqueException
     */
    public void save() throws TorqueException
    {
        save(TurbinePermissionPeer.DATABASE_NAME);
    }

    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.
     * Note: this code is here because the method body is
     * auto-generated conditionally and therefore needs to be
     * in this file instead of in the super class, BaseObject.
     *
     * @param dbName
     * @throws TorqueException
     */
    public void save(String dbName) throws TorqueException
    {
        Connection con = null;
        try
        {
            con = Transaction.begin(dbName);
            save(con);
            Transaction.commit(con);
        }
        catch(TorqueException e)
        {
            Transaction.safeRollback(con);
            throw e;
        }
    }

    /** flag to prevent endless save loop, if this object is referenced
        by another object which falls in this transaction. */
    private boolean alreadyInSave = false;
    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.  This method
     * is meant to be used as part of a transaction, otherwise use
     * the save() method and the connection details will be handled
     * internally
     *
     * @param con
     * @throws TorqueException
     */
    public void save(Connection con) throws TorqueException
    {
        if (!alreadyInSave)
        {
            alreadyInSave = true;



            // If this object has been modified, then save it to the database.
            if (isModified())
            {
                if (isNew())
                {
                    TurbinePermissionPeer.doInsert((TurbinePermission) this, con);
                    setNew(false);
                }
                else
                {
                    TurbinePermissionPeer.doUpdate((TurbinePermission) this, con);
                }
            }


            if (collTurbineRolePermissions != null)
            {
                for (int i = 0; i < collTurbineRolePermissions.size(); i++)
                {
                    ((TurbineRolePermission) collTurbineRolePermissions.get(i)).save(con);
                }
            }
            alreadyInSave = false;
        }
    }


    /**
     * Set the PrimaryKey using ObjectKey.
     *
     * @param key permissionId ObjectKey
     */
    public void setPrimaryKey(ObjectKey key)
        throws TorqueException
    {
        setPermissionId(((NumberKey) key).intValue());
    }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) throws TorqueException
    {
        setPermissionId(Integer.parseInt(key));
    }


    /**
     * returns an id that differentiates this object from others
     * of its class.
     */
    public ObjectKey getPrimaryKey()
    {
        return SimpleKey.keyFor(getPermissionId());
    }
 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     */
    public TurbinePermission copy() throws TorqueException
    {
        return copy(true);
    }

    /**
     * Makes a copy of this object using connection.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     *
     * @param con the database connection to read associated objects.
     */
    public TurbinePermission copy(Connection con) throws TorqueException
    {
        return copy(true, con);
    }

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * If the parameter deepcopy is true, it then fills all the
     * association collections and sets the related objects to
     * isNew=true.
     *
     * @param deepcopy whether to copy the associated objects.
     */
    public TurbinePermission copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new TurbinePermission(), deepcopy);
    }

    /**
     * Makes a copy of this object using connection.
     * It creates a new object filling in the simple attributes.
     * If the parameter deepcopy is true, it then fills all the
     * association collections and sets the related objects to
     * isNew=true.
     *
     * @param deepcopy whether to copy the associated objects.
     * @param con the database connection to read associated objects.
     */
    public TurbinePermission copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new TurbinePermission(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected TurbinePermission copyInto(TurbinePermission copyObj) throws TorqueException
    {
        return copyInto(copyObj, true);
    }

  
    /**
     * Fills the copyObj with the contents of this object using connection.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param con the database connection to read associated objects.
     */
    protected TurbinePermission copyInto(TurbinePermission copyObj, Connection con) throws TorqueException
    {
        return copyInto(copyObj, true, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * If deepcopy is true, The associated objects are also copied
     * and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param deepcopy whether the associated objects should be copied.
     */
    protected TurbinePermission copyInto(TurbinePermission copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setPermissionId(permissionId);
        copyObj.setName(name);

        copyObj.setPermissionId( 0);

        if (deepcopy)
        {


        List<TurbineRolePermission> vTurbineRolePermissions = getTurbineRolePermissions();
        if (vTurbineRolePermissions != null)
        {
            for (int i = 0; i < vTurbineRolePermissions.size(); i++)
            {
                TurbineRolePermission obj =  vTurbineRolePermissions.get(i);
                copyObj.addTurbineRolePermission(obj.copy());
            }
        }
        else
        {
            copyObj.collTurbineRolePermissions = null;
        }
        }
        return copyObj;
    }
        
    
    /**
     * Fills the copyObj with the contents of this object using connection.
     * If deepcopy is true, The associated objects are also copied
     * and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param deepcopy whether the associated objects should be copied.
     * @param con the database connection to read associated objects.
     */
    protected TurbinePermission copyInto(TurbinePermission copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setPermissionId(permissionId);
        copyObj.setName(name);

        copyObj.setPermissionId( 0);

        if (deepcopy)
        {


        List<TurbineRolePermission> vTurbineRolePermissions = getTurbineRolePermissions(con);
        if (vTurbineRolePermissions != null)
        {
            for (int i = 0; i < vTurbineRolePermissions.size(); i++)
            {
                TurbineRolePermission obj =  vTurbineRolePermissions.get(i);
                copyObj.addTurbineRolePermission(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collTurbineRolePermissions = null;
        }
        }
        return copyObj;
    }
    
    

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public TurbinePermissionPeer getPeer()
    {
        return peer;
    }

    /**
     * Retrieves the TableMap object related to this Table data without
     * compiler warnings of using getPeer().getTableMap().
     *
     * @return The associated TableMap object.
     */
    public TableMap getTableMap() throws TorqueException
    {
        return TurbinePermissionPeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("TurbinePermission:\n");
        str.append("PermissionId = ")
           .append(getPermissionId())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        return(str.toString());
    }
}