package io.oasp.gastronomy.restaurant.general.common.api.constants;

/**
 * Contains constants for the keys of all
 * {@link io.oasp.module.security.common.api.accesscontrol.AccessControlPermission}s.
 *
 */
public abstract class PermissionConstants {

  // put your permission names from access-control-schema.xml as constants here (or generate with cobigen)
  // BEGIN ARCHETYPE SKIP

  /** {@link io.oasp.module.security.common.api.accesscontrol.AccessControlPermission} to retrieve staff member. */
  public static final String FIND_STAFF_MEMBER = "FindStaffMember";

  /** {@link io.oasp.module.security.common.api.accesscontrol.AccessControlPermission} to save staff member. */
  public static final String SAVE_STAFF_MEMBER = "SaveStaffMember";

  /** {@link io.oasp.module.security.common.api.accesscontrol.AccessControlPermission} to remove staff member. */
  public static final String DELETE_STAFF_MEMBER = "DeleteStaffMember";

}
