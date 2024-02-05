import { Option } from '@/types/request';
import axios from 'axios';

export const axiosInstance = axios.create({
  baseURL: `${process.env.NEXT_PUBLIC_API_URL}`,
});

const create = (options?: Option) => {
  const instance = axios.create(
    Object.assign(
      { baseURL: process.env.NEXT_PUBLIC_API_URL, withCredentials: true },
      options,
    ),
  );

  return instance;
};

export const api = create();
