import axios from 'axios'
import { getToken } from "./AuthService";

const DEPARTMENT_REST_API_BASE_URL = 'http://localhost:8080/api/departments'

axios.interceptors.request.use(function (config) {
    config.headers['Authorization'] = getToken();
    return config;
}, function (error) {
    return Promise.reject(error);
});

export const getAllDepartments = () => axios.get(DEPARTMENT_REST_API_BASE_URL);

export const createDepartment = (department) => axios.post(DEPARTMENT_REST_API_BASE_URL, department);

export const getDepartmentById = (departmentId) => axios.get(DEPARTMENT_REST_API_BASE_URL + '/' + departmentId);

export const updateDepartment = (departmentId, department) => axios.put(DEPARTMENT_REST_API_BASE_URL+ '/' + departmentId, department);

export const deleteDepartment = (departmentId) => axios.delete(DEPARTMENT_REST_API_BASE_URL+ '/' + departmentId);
