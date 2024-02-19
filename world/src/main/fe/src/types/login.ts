export interface LoginInfoType {
  id: string;
  password: string;
  name?: string;
}

export enum LoginInfoEnum {
  ID = 'id',
  NAME = 'name',
  PASSWORD = 'password',
}
